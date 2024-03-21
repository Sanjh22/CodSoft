import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String contactName;
    private String contactNumber;
    private String emailAddress;

    public Contact(String contactName, String contactNumber, String emailAddress) {
        this.contactName = contactName;
        this.contactNumber = contactNumber;
        this.emailAddress = emailAddress;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}

class AddressBookManager {
    private ArrayList<Contact> contacts;

    public AddressBookManager() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(String contactName) {
        for (Contact contact : contacts) {
            if (contact.getContactName().equalsIgnoreCase(contactName)) {
                contacts.remove(contact);
                System.out.println("Contact removed successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void searchContact(String contactName) {
        for (Contact contact : contacts) {
            if (contact.getContactName().equalsIgnoreCase(contactName)) {
                System.out.println("Contact found:");
                displayContact(contact);
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void displayAllContacts() {
        System.out.println("All contacts:");
        for (Contact contact : contacts) {
            displayContact(contact);
        }
    }

    private void displayContact(Contact contact) {
        System.out.println("Name: " + contact.getContactName());
        System.out.println("Phone: " + contact.getContactNumber());
        System.out.println("Email: " + contact.getEmailAddress());
        System.out.println();
    }
}

public class Task_3_AddressBookSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBookManager manager = new AddressBookManager();

        int choice;
        do {
            System.out.println("Address Book System");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter contact name: ");
                    String contactName = scanner.nextLine();
                    System.out.println("Enter contact number: ");
                    String contactNumber = scanner.nextLine();
                    System.out.println("Enter email address: ");
                    String emailAddress = scanner.nextLine();
                    manager.addContact(new Contact(contactName, contactNumber, emailAddress));
                    break;
                case 2:
                    System.out.println("Enter contact name to remove: ");
                    String nameToRemove = scanner.nextLine();
                    manager.removeContact(nameToRemove);
                    break;
                case 3:
                    System.out.println("Enter contact name to search: ");
                    String nameToSearch = scanner.nextLine();
                    manager.searchContact(nameToSearch);
                    break;
                case 4:
                    manager.displayAllContacts();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
