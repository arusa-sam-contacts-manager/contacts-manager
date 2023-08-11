import java.util.*;

public class ContactsApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ContactsManager manager = new ContactsManager();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    showAllContacts();
                    break;

                case 2:
                    addNewContact();
                    break;

                case 3:
                    searchContactsByName();
                    break;

                case 4:
                    deleteContact();
                    break;

                case 5:
                    exit();
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Contacts Manager:");
        System.out.println("1. Show all contacts");
        System.out.println("2. Add a new contact");
        System.out.println("3. Search contacts by name");
        System.out.println("4. Delete a contact");
        System.out.println("5. Exit");
    }

    private static int getChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    private static void showAllContacts() {
    System.out.println("Name            | Phone number ");
    System.out.println("--------------------------------");
    for (Contact contact : manager.getAllContacts()) {
        System.out.printf("%-15s | %-12s%n", contact.getName(), contact.getNumber());
    }
}


    private static String formatPhoneNumber(String number) {
        // Remove any non-digit characters from the input
        String digits = number.replaceAll("\\D", "");

        // Check if the number is of valid length (7 or 10 digits)
        if (digits.length() == 7) {
            return digits.substring(0, 3) + "-" + digits.substring(3);
        } else if (digits.length() == 10) {
            return "(" + digits.substring(0, 3) + ") " + digits.substring(3, 6) + "-" + digits.substring(6);
        } else {
            return "Invalid phone number length";
        }
    }



    private static void addNewContact() {
        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter number: ");
        String number = scanner.next();


        String formattedNumber = formatPhoneNumber(number);

        manager.addContact(name, formattedNumber);
        System.out.println("Contact added: " + manager.searchContactByName(name));



//        manager.addContact(name, number);
//        System.out.println("Contact added: " + manager.searchContactByName(name));
    }

    private static void searchContactsByName() {
        System.out.print("Enter name to search: ");
        String searchName = scanner.next();
        Contact foundContact = manager.searchContactByName(searchName);
        if (foundContact != null) {
            System.out.println("Contact found - Name: " + foundContact.getName() + ", Number: " + foundContact.getNumber());
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void deleteContact() {
        System.out.print("Enter name to delete: ");
        String deleteName = scanner.next();
        manager.deleteContact(deleteName);
        System.out.println("Contact deleted.");
    }

    private static void exit() {
        System.out.println("Exiting Contacts ...");
        scanner.close();
        System.exit(0);
    }



}






