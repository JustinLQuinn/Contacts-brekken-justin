Contacts Manager Application

Our application will be used to keep track of "contacts".

Our application is able to:

Show all your contacts Add a new contact Search a contact by their name Delete an existing contact

When the application starts, the contact list should is read from the file. The contacts file is edited durring functions execution. The main menu is responsive dependent on if the contact list has any entries in the file.

Full Menu:

1) View contacts
2) Add a new contact
3) Search a contact by name
4) Delete an existing contact
5) Exit 
Enter an option (1, 2, 3, 4 or 5):

Restricted Menu:

1) Add a new contact
2) Exit 
Enter an option (1 or 2):

The contact's information is shown in the following format:

Name | Phone number
---------------
Jack Blank | 1231231234
Jane Doe | 2342342345
Sam Space | 3453453456
Here is what the code for your application might look like:

Load all the contacts by calling a method that returns a List of Contact objects.
Call a method that shows the user the main menu and returns their choice of action.
Using the user's choice from the previous step, call a method that performs that action (modifying the contents of the List of Contact objects if applicable).
Keep calling the method from step two until the user chooses to exit.
Once the user chooses to exit, re-write the contents of the contacts.txt file using the List of Contact objects.

***Bonus***

Format the phone numbers using dashes:

instead of 8675309, your output should display 867-5309

Allow formatting phone numbers with different lengths. For example, phone numbers can have 10 or 7 digits. You can be even more creative here and allow international phone numbers.

Warn the user when she tries to enter a contact with an existing name.


There's already a contact named Jane Doe. Do you want to overwrite it? (Yes/No)
If the answer is No allow the user to enter the information again.

Format the output of the contacts, so that all of the columns have the same width.

Name       | Phone number |
---------------------------
Jack Blank | 210-567-8923 |
Jane Doe   | 789-8902     |
Sam Space  | 210-581-8123 |

c:\dos\user\contacts.txt