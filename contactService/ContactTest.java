package contactService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    // Test the creation of a valid contact
    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("1", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    // Test the creation of a contact with invalid data, expecting exceptions
    @Test
    public void testInvalidContactCreation() {
        // Test null and over-length contactId
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));

        // Test null and over-length firstName
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", null, "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "JohnJohnJohn", "Doe", "1234567890", "123 Main St"));

        // Test null and over-length lastName
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "John", null, "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "John", "DoeDoeDoeDoe", "1234567890", "123 Main St"));

        // Test null, under-length, and over-length phone number
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "John", "Doe", null, "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "John", "Doe", "12345", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "John", "Doe", "12345678901", "123 Main St"));

        // Test null and over-length address
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "John", "Doe", "1234567890", null));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "John", "Doe", "1234567890", "1234567890123456789012345678901"));
    }

    // Test the setters for firstName, lastName, phone, and address with valid values
    @Test
    public void testSettersWithValidValues() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");

        // Valid updates
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());

        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());

        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());

        contact.setAddress("456 Elm St");
        assertEquals("456 Elm St", contact.getAddress());
    }

    // Test the setters with invalid values, expecting exceptions
    @Test
    public void testSettersWithInvalidValues() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");

        // Test invalid firstName
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("JohnJohnJohn"));

        // Test invalid lastName
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("DoeDoeDoeDoe"));

        // Test invalid phone number
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("12345"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("12345678901"));

        // Test invalid address
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress("1234567890123456789012345678901"));
    }

    // Test boundary values for contactId, phone, and address
    @Test
    public void testBoundaryValues() {
        // Test with minimum and maximum valid values
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123456789012345678901234567890");
        assertEquals("1", contact.getContactId());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123456789012345678901234567890", contact.getAddress());

        // Update firstName with boundary values
        contact.setFirstName("A");
        assertEquals("A", contact.getFirstName());
        contact.setFirstName("1234567890");
        assertEquals("1234567890", contact.getFirstName());
    }

    // Test no unexpected behavior occurs with multiple updates
    @Test
    public void testNoUnexpectedBehavior() {
        // Ensure that setting fields multiple times doesn't cause unexpected behavior
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");

        // Change firstName multiple times
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
        contact.setFirstName("John");
        assertEquals("John", contact.getFirstName());

        // Change lastName multiple times
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
        contact.setLastName("Doe");
        assertEquals("Doe", contact.getLastName());

        // Change phone multiple times
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
        contact.setPhone("1234567890");
        assertEquals("1234567890", contact.getPhone());

        // Change address multiple times
        contact.setAddress("456 Elm St");
        assertEquals("456 Elm St", contact.getAddress());
        contact.setAddress("123 Main St");
        assertEquals("123 Main St", contact.getAddress());
    }
}
