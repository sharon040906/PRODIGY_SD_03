package com.contact;
import java.util.*;

	class Contact {
	    String name;
	    String phone;
	    String email;

	    Contact(String name, String phone, String email) {
	        this.name = name;
	        this.phone = phone;
	        this.email = email;
	    }
	}

	public class ContactManager {

	    static ArrayList<Contact> contacts = new ArrayList<>();

	    // Add Contact
	    public static void addContact(Scanner sc) {
	        System.out.print("Enter Name: ");
	        String name = sc.nextLine();

	        System.out.print("Enter Phone: ");
	        String phone = sc.nextLine();

	        System.out.print("Enter Email: ");
	        String email = sc.nextLine();

	        contacts.add(new Contact(name, phone, email));
	        System.out.println("Contact added successfully!");
	    }

	    // View Contacts
	    public static void viewContacts() {
	        if (contacts.isEmpty()) {
	            System.out.println("No contacts found.");
	            return;
	        }

	        for (Contact c : contacts) {
	            System.out.println("Name: " + c.name +
	                               ", Phone: " + c.phone +
	                               ", Email: " + c.email);
	        }
	    }

	    // Search Contact
	    public static void searchContact(Scanner sc) {
	        System.out.print("Enter name to search: ");
	        String name = sc.nextLine();

	        for (Contact c : contacts) {
	            if (c.name.equalsIgnoreCase(name)) {
	                System.out.println("Found: " + c.name + ", " + c.phone + ", " + c.email);
	                return;
	            }
	        }

	        System.out.println("Contact not found.");
	    }

	    // Delete Contact
	    public static void deleteContact(Scanner sc) {
	        System.out.print("Enter name to delete: ");
	        String name = sc.nextLine();

	        Iterator<Contact> it = contacts.iterator();

	        while (it.hasNext()) {
	            Contact c = it.next();
	            if (c.name.equalsIgnoreCase(name)) {
	                it.remove();
	                System.out.println("Contact deleted.");
	                return;
	            }
	        }

	        System.out.println("Contact not found.");
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        while (true) {
	            System.out.println("\n1. Add Contact");
	            System.out.println("2. View Contacts");
	            System.out.println("3. Search Contact");
	            System.out.println("4. Delete Contact");
	            System.out.println("5. Exit");

	            System.out.print("Enter choice: ");
	            int choice = sc.nextInt();
	            sc.nextLine(); // buffer fix

	            switch (choice) {
	                case 1:
	                    addContact(sc);
	                    break;
	                case 2:
	                    viewContacts();
	                    break;
	                case 3:
	                    searchContact(sc);
	                    break;
	                case 4:
	                    deleteContact(sc);
	                    break;
	                case 5:
	                    System.out.println("Exiting...");
	                    return;
	                default:
	                    System.out.println("Invalid choice");
	            }
	        }
	    }
	}
