import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class FileInspector {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        File selectedFile;
        String line;
        String fileName;
        int lineCount = 0;
        int wordCount = 0;
        int characterCount = 0;
        // ArrayList<Object> wordCounter = new ArrayList<>();
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src"); // opens in project src folder
        chooser.setCurrentDirectory(target.toFile());
        try  // Below is if file is selected
        {
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) // File choosen
            {
                selectedFile = chooser.getSelectedFile();
                fileName = selectedFile.getName();
                System.out.println("File name: " + fileName);
                target = chooser.getSelectedFile().toPath();  // File object, not a String filename
                inFile = new Scanner(target); // uses the scanner to analyze each line!
                do {
                    line = inFile.nextLine();
                    wordCount += line.split("\\s+").length;
                    characterCount += line.length();
                    System.out.println(line); // echos the file text
                    lineCount++;
                } while (inFile.hasNextLine());
                inFile.close(); // close file
                System.out.println("Line Count: " + lineCount);
                System.out.println("Word Count: " + wordCount);
                System.out.println("Character Count: " + characterCount);
            }
            else   // File chooser closed
            {
                System.out.println("You have to select a file! Ending program.");
                System.exit(0);
            }
        }
        catch (FileNotFoundException e) // Errors other than unpicked file
        {
            System.out.println("File Not Found Error!");
            e.printStackTrace();
        }
        catch (IOException e) // code to handle this exception
        {
            System.out.println("IOException Error!");
            e.printStackTrace();
        }
    }

}