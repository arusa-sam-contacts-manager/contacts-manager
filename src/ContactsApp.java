import java.util.Scanner;

public class ContactsApp {
    public static void main(String[] args) {
        ContactsManager manager = new ContactsManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Contacts Manager:");
            System.out.println("1. Show all contacts");
            System.out.println("2. Add a new contact");
            System.out.println("3. Search contacts by name");
            System.out.println("4. Delete a contact");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    for (Contact contact : manager.getAllContacts()) {
                        System.out.println("Name: " + contact.getName() + ", Number: " + contact.getNumber());
                    }
                    break;

                case 2:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter number: ");
                    String number = scanner.nextLine();
                    manager.addContact(new Contact(name, number));
                    System.out.println("Contact added.");
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    Contact foundContact = manager.searchContactByName(searchName);
                    if (foundContact != null) {
                        System.out.println("Contact found - Name: " + foundContact.getName() + ", Number: " + foundContact.getNumber());
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter name to delete: ");
                    String deleteName = scanner.nextLine();
                    manager.deleteContact(deleteName);
                    System.out.println("Contact deleted.");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

