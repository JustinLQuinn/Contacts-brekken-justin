package contacts;

import java.util.Scanner;

import static contacts.ContactsMain.showMenu;

public class ContactsApp {




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
                ContactsMain.error("Unknown Option: " + choice);
                showMenu();
                return;
            }
        }
        showMenu();
    }

//    public void start() {
//        showMenu();
//    }





    private static void exit() {

        ContactsMain.goodbye();
        System.exit(0);
    }
}
