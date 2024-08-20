package contactService;
import java.util.HashMap; // Import HashMap class from java.util package
import java.util.Map; // Import Map interface from java.util package

public class ContactService {
    // A map to store contacts with the contact ID as the key
    private Map<String, Contact> contacts;

    // Constructor initializes the contact map
    public ContactService() {
        contacts = new HashMap<>();
    }

    // Method to add a new contact to the service
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists.");
        }
        contacts.put(contact.getContactId(), contact);
    }

    // Method to delete a contact by its ID
    public void deleteContact(String id) {
        Contact contact = contacts.get(id);
        if (contact == null) {
            // Throw an exception if the contact does not exist
            throw new IllegalArgumentException("Contact with ID " + id + " does not exist.");
        }
        contacts.remove(id);
    }

    // Method to update the first name of a contact
    public void updateFirstName(String id, String newFirstName) {
        Contact contact = contacts.get(id);
        if (contact == null) {
            // Throw an exception if the contact does not exist
            throw new IllegalArgumentException("Contact with ID " + id + " does not exist.");
        }
        contact.setFirstName(newFirstName);
    }

    // Method to update the last name of a contact
    public void updateLastName(String id, String newLastName) {
        Contact contact = contacts.get(id);
        if (contact == null) {
            // Throw an exception if the contact does not exist
            throw new IllegalArgumentException("Contact with ID " + id + " does not exist.");
        }
        contact.setLastName(newLastName);
    }

    // Method to update the phone number of a contact
    public void updatePhone(String id, String newPhone) {
        Contact contact = contacts.get(id);
        if (contact == null) {
            // Throw an exception if the contact does not exist
            throw new IllegalArgumentException("Contact with ID " + id + " does not exist.");
        }
        contact.setPhone(newPhone);
    }

    // Method to update the address of a contact
    public void updateAddress(String id, String newAddress) {
        Contact contact = contacts.get(id);
        if (contact == null) {
            // Throw an exception if the contact does not exist
            throw new IllegalArgumentException("Contact with ID " + id + " does not exist.");
        }
        contact.setAddress(newAddress);
    }

    // Method to retrieve a contact by its ID
    public Contact getContact(String id) {
        return contacts.get(id);
    }
}
