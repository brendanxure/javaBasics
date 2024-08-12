import java.io.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWriteExample {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final int READ = 1;
        final int WRITE = 2;
        final int EXIT = 3;

        System.out.println("Choose an option: ");
        System.out.println("1. Read from a file");
        System.out.println("2. Write to a file");
        System.out.println("3. Exit");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == READ) {
            readFile();
        } else if (choice == WRITE) {
            writeFile();
        } else if (choice != EXIT) {
            System.out.println("Invalid choice.");
        }
    }

    public static void readFile() {
        String fileName = "//C:/Users/Senter/IdeaProjects/Files/src/example.txt";
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile() {
        System.out.println("Enter text to write to the file:");
        String userInput = scanner.nextLine();
        String fileOutput = "//C:/Users/Senter/IdeaProjects/Files/src/output.txt";
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileOutput));
            bw.write(userInput);
            System.out.println("Text written to file successfully.");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

