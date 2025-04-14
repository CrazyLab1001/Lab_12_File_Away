import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class DataSaver {
    public static void main(String[] args) {
        ArrayList <String> toRecord = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String firstName;
        String lastName;
        int unformattedID;
        String formattedID;
        String email;
        int yearOfBirth;
        // initialize all variables first or you'll break java in the do while loop
        boolean done = false;
        do {
            firstName = SafeInput.getNonZeroLenString(in, "What's the first name?");
            lastName = SafeInput.getNonZeroLenString(in, "What's the last name?");
            unformattedID = SafeInput.getRangedInt(in, "What's the ID number?", 0, 999999);
            formattedID = String.format("%06d", unformattedID);
            email = SafeInput.getNonZeroLenString(in, "What's the email?");
            yearOfBirth = SafeInput.getRangedInt(in, "What's the year of birth?", 1000, 9999);

            toRecord.add(firstName + ", " + lastName + ", " + formattedID + ", " + email + ", " + yearOfBirth);

            done = SafeInput.getYNConfirm(in, "Data recorded! Is that all of your data? [Y/N]");
        } while (!done);
        // prompt for data inputs of Name, ID, email, and YOB. They'll be compiled together in the ArrayList "toRecord"

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\data.txt"); // creates/overrides data.txt in
        try{
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for (String rec : toRecord) {
                writer.write(rec,0, rec.length());
                writer.newLine();
            } // writes line by line
            writer.close();

            System.out.println("File written! Closing program. :)");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
