import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class DataSaver {
    public static void main(String[] args) {
        ArrayList <String> toRecord = new ArrayList<>();
        String stringDataInput;
        // prompt for data inputs of Name, ID, email, and YOB. They'll be compiled together in the ArrayList "toRecord"
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\data.txt"); // creates/overrides data.txt in
        try{
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            // Bufferedwriter code here
            // for loop to write each line here. toRecord is recorded (lol) by each line; Six inputs.
            System.out.println("File written! Closing program. :)");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
