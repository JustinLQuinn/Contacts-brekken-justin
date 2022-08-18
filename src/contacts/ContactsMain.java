package contacts;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ContactsMain {
    public static void main(String[] args) {
    }



        private static final String contactsFormat = "| %-10s | %10s |\n";

        public static void showMenu() {
            System.out.println("");
            System.out.println("0 - Exit");
            System.out.println("1 - View Contacts");
            System.out.println("2 - Add A Contact");
            System.out.println("3 - Search Contacts");
            System.out.println("4 - Remove A Contact");
            System.out.println();
            System.out.print("Your choice? ");
        }

        public static void error (String message){
            System.err.println("An error occured!");
            System.out.println("ERROR: " + message);
        }
        public static void error () {
            error("An unknown error occurred");
        }


        public static void goodbye () {
            System.out.println("--------------------");
            System.out.println("| Have a great day! |");
            System.out.println("--------------------");
            System.out.println("| Goodbye! |");
            System.out.println();
        }



}
