package contacts;

import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class ContactsApp {
    public static final String PURPLE_BACKGROUND = "\u001B[45m";
    public static final String BLACK = "\u001B[30m";

    public static ArrayList<Contact> createContactsArr(Path path) throws IOException {
        List<String> printList = Files.readAllLines(path);

        ArrayList<Contact> contactArr = new ArrayList<>();

        for (int i = 0; i < printList.size(); i += 2) {
            contactArr.add(new Contact(printList.get(i), printList.get(i + 1)));
        }
        return contactArr;
    }

    public static void initiateContacts() throws IOException {

        Input input = new Input();
        String directory = "./src/contacts/data";
        String fileName = "contacts.txt";
        Path dataFile = Paths.get(directory, fileName);
        System.out.println(BLACK);
        System.out.println(PURPLE_BACKGROUND);

        do {
            if (Files.readAllBytes(dataFile).length > 0) {
                List<String> printList = Files.readAllLines(dataFile);
                System.out.printf("1) Show contacts \n2) Search a contact (by name) \n3) Add a new contact \n4) Delete a contact \n5) Exit program \nEnter an option plz [1, 2, 3, 4 or 5]:%n");
                String userSelection = input.getString();

                switch (userSelection) {
                    case "1" -> showContacts(printList);
                    case "2" -> searchContacts(dataFile, input);
                    case "3" -> addContact(dataFile);
                    case "4" -> deleteContact(dataFile, input);
                    case "5" -> exit();
                }
            }else{
                List<String> printList = Files.readAllLines(dataFile);
                System.out.printf("1) Add a contact \n2) Exit program \nEnter an option plz [1 or 2]:%n");
                String userSelection = input.getString();

                switch (userSelection) {
                    case "1" -> addContact(dataFile);
                    case "2" -> exit();
                }
            }
        } while (true);
    }

    public static void main(String[] args) throws IOException {
        initiateContacts();
    }

    public static void showContacts(List<String> stringList) {
        System.out.println();
        System.out.println("Name   |   Phone Number");
        System.out.println("----------------------");

        for (int i = 0; i < stringList.size(); i += 2) {
            System.out.println(stringList.get(i) + " | " + stringList.get(i + 1));
        }
        System.out.println();
    }

    public static void addContact(Path path) throws IOException {
        Input input = new Input();

        System.out.println("~~~  Add a Contact  ~~~");
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
        showContacts(printList);
    }

    public static void searchContacts(Path path, Input input) throws IOException {
        ArrayList<Contact> contactArr = createContactsArr(path);
        System.out.println("Enter contact name: ");
        String userSearch = input.getString();

        boolean found = false;

        for (Contact contact : contactArr) {
            if (userSearch.equalsIgnoreCase(contact.name)) {
                System.out.printf("%s | %s%n", contact.name, contact.number);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.printf("%nDesired contact %s not found%n", userSearch);
            searchContacts(path, input);
        }
    }

    public static void deleteContact(Path path, Input input) throws IOException {
        ArrayList<Contact> contactArr = createContactsArr(path);
        System.out.println("Enter a contact: ");
        String userSearch = input.getString();

        List<String> newArrList = new ArrayList<>();

        for (Contact contact : contactArr) {
            if (userSearch.equalsIgnoreCase(contact.name)) {
                continue;
            }
            newArrList.add(contact.name);
            newArrList.add(contact.number);
        }
        Files.write(path, newArrList);
        initiateContacts();
    }

        public static void goodbye () {
            System.out.println("--------------------");
            System.out.println("| Have a wonderful day! |");
            System.out.println("--------------------");
            System.out.println("| Godspeed! |");
            System.out.println();
        }

        public static void exit() {
            goodbye();
            System.exit(0);
        }
    }


