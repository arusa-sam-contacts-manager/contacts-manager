import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContactsManager {
    private List<Contact> contacts;
    private static final String FILE_PATH = "data/contacts.txt";

    public ContactsManager() {
        contacts = new ArrayList<>();
        loadContactsFromFile();
    }

    public void addContact(String name, String number) {
        Contact contact = new Contact(name, number);
        contacts.add(contact);
        saveContactsToFile();
    }

    public void deleteContact(String name) {
        contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(name));
        saveContactsToFile();
    }

    public Contact searchContactByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public List<Contact> getAllContacts() {
        return contacts;
    }

    private void saveContactsToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (Contact contact : contacts) {
                writer.println(contact.getName() + "," + contact.getNumber());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadContactsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    String number = parts[1].trim();
                    contacts.add(new Contact(name, number));
                }
            }
        } catch (IOException e) {
        }
    }
}


