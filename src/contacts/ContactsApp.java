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

    public static void initiateContacts() throws IOException {

        Input input = new Input();
        String directory = "./src/contacts/data";
        String fileName = "contacts.txt";
        Path dataFile = Paths.get(directory, fileName);

        boolean confirmation = true;

        do {
            List<String> printList = Files.readAllLines(dataFile);
            loadList(printList);
            System.out.printf("1. View contacts.\n2. Add a new contact.\n3. Search a contact by name.\n4. Delete an existing contact.\n5. Exit.\nEnter an option (1, 2, 3, 4 or 5):%n");
            String userSelection = input.getString();
            System.out.println("userSelection = " + userSelection);

            switch (userSelection) {
                case "1" -> initiateContacts();
                case "2" -> addContact(dataFile);
//                case "3" -> searchContact(dataFile, input);
//                case "4" -> deleteContact(dataFile, input);
                case "5" -> exit();
            }
        } while (true);
    }


    public static void main(String[] args) throws IOException {
        initiateContacts();
    }



    public static void loadList(List<String> stringList) {
        System.out.println();
        System.out.println("Name  |   Phone Number");
        System.out.println("----------------------");

        for(int i = 0; i < stringList.size(); i += 2){
            System.out.println(stringList.get(i) + " | " + stringList.get(i+1));
        }
        System.out.println();
    }


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
