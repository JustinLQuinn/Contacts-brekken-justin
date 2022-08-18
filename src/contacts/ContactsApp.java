package contacts;

import java.util.Scanner;


public class ContactsApp {

    private static void showMenu() {
        System.out.println("");
        System.out.println("0 - Exit");
        System.out.println("1 - View Contacts");
        System.out.println("2 - Add A Contact");
        System.out.println("3 - Search Contacts");
        System.out.println("4 - Remove A Contact");
        System.out.println();
        System.out.print("Your choice? ");
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        showMenu();
        String choice = scanner.nextLine();

        switch (choice) {
            case "0" -> exit();
            case "1" -> System.out.println("helloq");
            case "2" -> System.out.println("hello2");
            case "3" -> System.out.println("hello3");
            case "4" -> System.out.println("hello");
            default -> {
                showMenu();
                return;
            }
        }
        showMenu();
    }

//    public void start() {
//        showMenu();
//    }

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


    private static void exit() {

        goodbye();
        System.exit(0);
    }
}
