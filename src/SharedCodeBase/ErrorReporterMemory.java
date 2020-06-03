package SharedCodeBase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class ErrorReporterMemory {

    private BufferedWriter errorLogFile;
    private final boolean print;
    private final ErrorReporter errorReporter;
    private final StringBuilder memory = new StringBuilder();

    public ErrorReporterMemory(File errorLogFile, ErrorReporter errorReporter, boolean print) {
        this.errorReporter = errorReporter;
        try {
            this.errorLogFile = new BufferedWriter(new FileWriter(errorLogFile));
        } catch (Exception e) {
            errorReporter.objectError(this, "file", e, 11);
        }
        this.print = print;
    }

    public void append(String toAdd) {
        memory.append(toAdd).append("\n");
    }

    public void FlushToFile() {
        String toFlush = memory.toString();
        if(print) System.out.print(toFlush);
        for (String color : COLOR.toArray()) toFlush = toFlush.replace(color, "");
        try {
            errorLogFile.write(toFlush + System.lineSeparator());
            errorLogFile.close();
        } catch (Exception e) {
            errorReporter.objectError(this, "errorLogFile", e, 10);
        }
    }
}
