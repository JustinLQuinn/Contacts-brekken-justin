package contacts;

import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
//import java.util.Locale;

public class ContactsApp {
    public static final String PURPLE_BACKGROUND = "\u001B[45m";
    public static final String BLACK = "\u001B[30m";

    public static ArrayList<Contact> createContactsArr(Path path) throws IOException {
        List<String> printList = Files.readAllLines(path);

        ArrayList<Contact> contactArr = new ArrayList<>();
        for (int i = 0; i < printList.size(); i++) {
            int b=Integer.parseInt(printList.get(i).split(",")[1]); 
            contactArr.add(new Contact(printList.get(i).split(",")[0], b));
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
            if (Files.readAllLines(dataFile).isEmpty()) {
                System.out.printf("1) Add a contact \n2) Exit program \nEnter an option plz [1 or 2]:%n");
                String userSelection = input.getString();

                switch (userSelection) {
                    case "1" -> addContact(dataFile);
                    case "2" -> exit();
                }
            }else{
                List<String> printList = Files.readAllLines(dataFile);
                System.out.printf("1) Show contacts \n2) Search a contact (by Name) \n3) Add a new contact \n4) Delete a contact \n5) Exit program \nEnter an option plz [1, 2, 3, 4 or 5]:%n");
                String userSelection = input.getString();

                switch (userSelection) {
                    case "1" -> showContacts(printList);
                    case "2" -> searchContacts(dataFile, input);
                    case "3" -> addContact(dataFile);
                    case "4" -> deleteContact(dataFile, input);
                    case "5" -> exit();
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

        for (int i = 0; i < stringList.size(); i++) {
            System.out.println(stringList.get(i).split(",")[0] + " | " + stringList.get(i).split(",")[1].replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3"));
        }
        System.out.println();

    }

    public static void addContact(Path path) throws IOException {
        Input input = new Input();

        System.out.println("~~~  Add a Contact  ~~~");
        System.out.println("Enter contact name: ");
        String contactName = input.getString();
        System.out.println("Enter your contact's phone number");
        Integer contactNumber = input.getInteger();
        String contactNumber2 = Integer.toString(contactNumber);
                    // System.out.println(contactNumber.length());//
                    // System.out.println();
            while(contactNumber2.length() != 10){
                System.out.println("Not 10 digits, Try again...");
                System.out.println("Enter your contact's phone number");
                contactNumber = input.getInteger();  
            }
            
        ArrayList<Contact> contactArr = new ArrayList<>();
        //1.) if (contactArr.contains(contactName) == true; ask user if "they
        // want to edit existing contact?"
        //2.) If yes go to editContact.
            //2b.) call contactName.editContact(arrayName,contactName).
        // 3.) If No, continue.
        contactArr.add(new Contact(contactName, contactNumber));
        for (Contact contact : contactArr) {
            List<String> contactList = Arrays.asList(contact.toString()); 
            Files.write(path, contactList, StandardOpenOption.APPEND);
            System.out.printf("%s has been added.\n", contactName);
        }
    
    }

    public static void searchContacts(Path path, Input input) throws IOException {
        ArrayList<Contact> contactArr = createContactsArr(path);
        System.out.println("Enter contact name: ");
        String userSearch = input.getString();
        System.out.println();
        boolean found = false;

        for (Contact contact : contactArr) {
            if (contact.name.toLowerCase().contains(userSearch.toLowerCase())) {
                System.out.printf("%s | %s%n", contact.name, contact.number.toString().replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3"));
                found = true;  
            }
        }
        if (!found) {
            System.out.printf("%nDesired contact %s not found%n", userSearch);
        }
        System.out.println();
    }

    public static void deleteContact(Path path, Input input) throws IOException {
        ArrayList<Contact> contactArr = createContactsArr(path);
        // System.out.print(contactArr);
        System.out.println("Enter a contact: ");
        String userSearch = input.getString();

        List<String> newArrList = new ArrayList<>();

        for (Contact contact : contactArr) {
            if ((contact.name.toLowerCase()).contains(userSearch.toLowerCase())) {
                continue;
            }else{
            newArrList.add(contact.name);
            newArrList.add(contact.number.toString());
            }
        }
        //add response if userSearch is not found in contactArr
        Files.write(path, newArrList);
        System.out.printf("%s has been removed.\n", userSearch);
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

        //static void newContactList() method ---
        //Input input = new Input();
        //Ask user for a List Name = fileName
            //String directory = "./src/contacts/data";
            //String fileName = "userInput";
            //Path dataFile = Paths.get(directory, fileName);
        //

    //Add EditContact(array, object name) method --- add EditContact for the object
    // item itself.
        //1) ask user what field to edit; Name or Number
        //2) initiate Scanner
        //3) selection will call method; contact.setName or contact.setNumber
        //2) initiate Scanner to fill in setter
        //4) enter runs the setter with the Scanner field as the intended value for
        // the setter

}
