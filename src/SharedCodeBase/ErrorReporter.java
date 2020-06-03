package SharedCodeBase;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class ErrorReporter {

    private final ArrayList<Field> private_fields = new ArrayList<>();
    private final ArrayList<Field> public_fields = new ArrayList<>();
    private ArrayList<String> tmp_field;
    private Class objectClass;
    private ErrorReporterMemory memory;
    private File directory, errorLogFile;
    private final HashMap<Integer, String> errors = new HashMap<>();
    private final HashMap<String, Boolean> arguments = new HashMap<>();
    private long finished_in;
    private Object object;
    private Stamp stamp;
    private String objectClassName, errorName, errorVariable, fieldName, lastType, type, value;
    private StringBuilder valueTemp = new StringBuilder();

    public ErrorReporter(String[] args) {
        System.out.println(COLOR.PURPLE + "Initialized ErrorReporter (version: " + Version.ver + ")" + COLOR.RESET);
        for(String arg: args) arguments.put(arg.split("=")[0], arg.split("=")[1].equals("true"));
        for(String key: new String[]{"development", "getPrivate"}) if(!arguments.containsKey(key)) arguments.put(key, false);
        errors.put(-1, "ERROR REPORTER TEST");
        errors.put(0,  "ARRAY MUST CONTAIN AT LEAST 2 NUMBERS");
        errors.put(1,  "FILE WAS NOT FOUND");
        errors.put(2,  "PLEASE SELECT FROM SHOWN POSSIBILITIES");
        errors.put(3,  "UNDEFINED ERROR OCCURRED");
        errors.put(4,  "FILE COULD NOT BE SAVED");
        errors.put(5,  "HASH MAP KEY WAS NOT FOUND");
        errors.put(6,  "STRING BUILDER ERROR");
        errors.put(7,  "PLEASE INPUT ONLY NUMBERS OR > - <");
        errors.put(8,  "FILE COULD NOT BE CREATED");
        errors.put(9,  "CAN NOT READ FROM FILE");
        errors.put(10, "CAN NOT WRITE INTO FILE");
        errors.put(11, "CAN NOT ATTACH WRITER TO FILE");
        errors.put(12, "CAN NOT CREATE DIRECTORY");
        errors.put(13, "ERROR ID NOT FOUND");
    }

    public void addOrUpdateArgument(String key, boolean value) {
        if(!arguments.containsKey(key)) arguments.put(key, value);
        if(arguments.get(key) != value) arguments.replace(key, value);
    }

    public void objectError(Object objectIn, String errorVariableIn, Exception exception, Integer errorId) {

        this.errorName = errors.get(errorId);
        if(errorName == null) objectError(this, "errorId", null, 13);

        this.errorVariable = errorVariableIn;

        this.object = objectIn;
        this.objectClass = object.getClass();
        this.objectClassName = objectClass.getSimpleName();

        try {
            directory = new File("logs");
            if(!directory.exists() && !directory.mkdir()) objectError(this, "directory", null, 12);
            errorLogFile = new File(directory + "/" + objectClassName + "-crash-" + Stamp.getDateAndTimeFileNames() + ".log");
            if (!errorLogFile.createNewFile()) objectError(this, "errorLog", null, 8);
        } catch (Exception e) {
            objectError(this, "errorLog", e, 8);
        }

        this.memory = new ErrorReporterMemory(errorLogFile, this, arguments.get("development"));

        this.stamp = new Stamp(new Date().getTime());

        memory.append(COLOR.RED + "--- " + objectClassName + " CRASHED: \"" + errorName + "\" ---" + COLOR.RESET);
        memory.append(COLOR.CYAN + "- Crash date and time: " + Stamp.getDate() + " " + Stamp.getFormattedTimeNow() + COLOR.RESET);
        memory.append(COLOR.CYAN + "- SharedCodeBase Version: " + Version.ver + COLOR.RESET);
        memory.append("");

        for(Field field: objectClass.getDeclaredFields()) {
            if (Modifier.isPublic(field.getModifiers())) public_fields.add(field);
            else private_fields.add(field);
        }

        if(public_fields.size() > 0) {
            memory.append(COLOR.YELLOW + "--- " + objectClassName + " PUBLIC VARIABLES ---" + COLOR.RESET);
            for(Field field : public_fields) printVariable(field);
        }

        if (arguments.get("getPrivate") && private_fields.size() > 0) {
            memory.append("\n" + COLOR.YELLOW + "--- " + objectClassName + " PRIVATE VARIABLES ---" + COLOR.RESET);
            for(Field field : private_fields) printVariable(field);
        }

        memory.append("");
        if (exception != null) memory.append(COLOR.CYAN + "--- JAVA THROWN EXCEPTION ---\n" + exception.getCause() + exception.getMessage() + COLOR.RESET);

        finished_in = new Date().getTime() - stamp.start_time;

        memory.append("");
        memory.append("--- ErrorReporter finished in " + ((finished_in < 15) ? COLOR.GREEN : ((finished_in < 25) ? COLOR.YELLOW : ((finished_in < 50) ? COLOR.ORANGE : COLOR.RED))) + finished_in + "ms" + COLOR.RESET + " ---");

        memory.FlushToFile();

        System.exit(errorId);
    }

    private void printVariable(Field field) {
        try {
            if(!Modifier.isPublic(field.getModifiers())) field.setAccessible(true);
            fieldName = field.getName();
            type = field.getType().toString();
            value = String.valueOf(field.get(object));

            if(type.contains(".")) type = type.substring(type.lastIndexOf(".") + 1).replace(";", "");
            if(!type.equals(lastType)) memory.append(COLOR.CYAN + "\n--- " + (lastType = type) + " ---" + COLOR.RESET);

            if(value.equals("") || value.equals("null") || value.equals("[]")) value = COLOR.ORANGE + "NULL";
            else {
                if (value.startsWith("[") && (value.endsWith("]"))) {
                    tmp_field = new ArrayList<>(Arrays.asList(value.split(", ")));
                    if(IsDigit.check(tmp_field.get(0).replace("[", "")) && tmp_field.size() > 30) value = tmp_field.get(0) + " .. " + (tmp_field.size() - 2) + " items .. " + tmp_field.get(tmp_field.size() - 1);
                    else {
                        for (String s: tmp_field) {
                            String[] splitted = s.split(" ");
                            String[] splitted_1 = splitted[1].split("\\.");
                            String[] splitted_2 = splitted[2].split("\\.");
                            valueTemp.append(splitted[0]).append(" ").append(splitted_1[splitted_1.length - 1]).append(" ").append(splitted_2[splitted_2.length - 1]).append("\n\t");
                        }
                        tmp_field.clear();
                        value = valueTemp.toString().replace("[", "[\n\t").replace("]\n\t", "\n]").replace("[\n\t[", "[").replace("]\n]", "\n]");
                    }
                } else if(type.equals("HashMap")) value = value.replace("{", "{\n\t").replace(", ", "\n\t").replace("}", "\n}").replace("=", " = ");
                else {
                    if (value.contains("@")) value = value.split("@")[0];
                    if (type.equals("ThreadGroup")) value = value.split("=")[1].split(",")[0];
                    if (!(type.equals("ArrayList") || type.equals("String") || type.equals("Field")) && value.contains("[")) value = value.split("\\[")[0];
                    if (!(type.equals("double") || type.equals("File")) && value.contains(".")) value = "new " + value.split("\\.")[value.split("\\.").length - 1];
                    if ((type.equals("String") || type.equals("ArrayList")) && value.contains(";")) value = value.split(";")[0] + " array";

                }
            }
            memory.append((fieldName.equals(errorVariable)?COLOR.RED:COLOR.BLUE) + "- " + fieldName + ": " + COLOR.RESET + COLOR.GREEN + value + COLOR.RESET);
        } catch (Exception e) {
            objectError(this, fieldName, e, 6);
        }
    }
}
 