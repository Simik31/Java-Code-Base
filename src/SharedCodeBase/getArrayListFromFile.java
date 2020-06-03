package SharedCodeBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class getArrayListFromFile {

    public static ArrayList<String> fileFromResourceToArrayList(String fileName) {

        ArrayList<String> lines = new ArrayList<>();
        File file = new File(fileName);

        try {

            lines.addAll(Files.readAllLines(file.toPath()));

        } catch (IOException e) {

            e.printStackTrace();
        }

        return lines;
    }

}
