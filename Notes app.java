import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NotesApp {

    static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== NOTES APP =====");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Enter your note: ");
                String note = sc.nextLine();

                try {
                    FileWriter writer = new FileWriter(FILE_NAME, true);

                    writer.write(note);
                    writer.write("\n");

                    writer.close();

                    System.out.println("Note saved successfully.");

                } catch (IOException e) {
                    System.out.println("Error while writing the note.");
                }

            } else if (choice == 2) {

                try {
                    FileReader reader = new FileReader(FILE_NAME);

                    int character;

                    System.out.println("\n----- YOUR NOTES -----");

                    while ((character = reader.read()) != -1) {
                        System.out.print((char) character);
                    }

                    reader.close();

                } catch (IOException e) {
                    System.out.println("No notes found.");
                }

            } else if (choice == 3) {

                System.out.println("Thank you for using Notes App.");
                break;

            } else {

                System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
}
