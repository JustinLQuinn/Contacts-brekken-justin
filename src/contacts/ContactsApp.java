package contacts;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;


public class ContactsApp {
//   static ArrayList<String> objects = new ArrayList<>();
public static ArrayList<Contact> createContactsArray(Path path) throws IOException {
    List<String> printList = Files.readAllLines(path);

    ArrayList<Contact> contactArr = new ArrayList<>();

    for(int i = 0; i < printList.size(); i += 2){
        contactArr.add(new Contact(printList.get(i), printList.get(i+1)));
    }

    return contactArr;

}

    private static void showMenu() {
        System.out.println("");
        System.out.println("0 - Exit");
        System.out.println("1 - Add A Contact");
        System.out.println("2 - Remove A Contact");
        System.out.println("3 - Search Contacts");
        System.out.println("4 - View Contacts");
        System.out.println();
        System.out.print("Your choice? ");
    }


    public static void main(String[] args) {
        System.out.println(loadList());
        Scanner scanner = new Scanner(System.in);
        showMenu();
        String choice = scanner.nextLine();
        //1. showContact();
        //2. searchContact();
        //3. addContact();
        //4. deleteContact();
        switch (choice) {
            case "0" -> exit();
            case "1" -> addContact();
//            case "2" -> deleteContact();
//            case "3" -> searchContact();
            case "4" -> loadList();
            default -> {
                showMenu();
                return;
            }
        }
        showMenu();
    }

//    public static String showContacts (objects) {
//        for (int i = 0; i < objects.size(); i++) {
//            for (int j = 0; j < objects[i].size(); j++) {
//                System.out.println(objects[i].[j].getName();
//                System.out.println(objects[i].[j].getNumber();
//            }
//            return objects.field[j].toString();
//        }

    public static void loadList(List<String> stringList) {
        System.out.println();
        System.out.println("Name  |   Phone Number");
        System.out.println("----------------------");

        for(int i = 0; i < stringList.size(); i += 2){
            System.out.println(stringList.get(i) + " | " + stringList.get(i+1));
        }
        System.out.println();
    }



//    private static void addContact() {
//        System.out.println("Let's add a new contact!");
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Let's add a Name.");
//        String name = scanner.nextLine();
//        System.out.println("Let's add their number.");
//        int phoneNumber = scanner.nextInt();
//        //pass values to object constructor
//       objects.add(String.valueOf(new Contact(name, phoneNumber)));
//        System.out.print(objects);
//
//
//        }
//    }
public static void addContact(Path path) throws IOException {
    Input input = new Input();

    System.out.println("--- Add a Contact ---");
    System.out.println("Enter contact name: ");
    String contactName = input.getString();
    System.out.println("Enter your contact's phone number");
    String contactNumber = input.getString();


    ArrayList<Contact> contactArr = new ArrayList<>();
    contactArr.add(new Contact(contactName, contactNumber));
    for (Contact contact : contactArr) {
        List<String> contactList = Arrays.asList(contact.name, contact.number);
        System.out.println("contactList = " + contactList);
        Files.write(path, contactList, StandardOpenOption.APPEND);
    }
    List<String> printList = Files.readAllLines(path);
    loadList(printList);
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


    private static void exit() {

        goodbye();
        System.exit(0);
    }
}
