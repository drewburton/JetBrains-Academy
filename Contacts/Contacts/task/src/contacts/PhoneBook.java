package contacts;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {
    private Scanner scanner;
    private ArrayList<Contact> contacts;

    public PhoneBook() {
        scanner = new Scanner(System.in);
        contacts = new ArrayList<>();
    }

    public void runMenu() {
        String action = "";
        while ("exit".equals(action)) {
            System.out.print("Enter action (add, remove, edit, count, list, exit): ");
            action = scanner.nextLine();
            switch (action) {
                case "add":
                    System.out.print("Enter the name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter the surname: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter the number: ");
                    String number = scanner.nextLine();
                    Contact contact = new Contact.Builder()
                            .setFirstName(firstName)
                            .setLastName(lastName)
                            .setNumber(number)
                            .build();
                    if ("".equals(contact.getNumber().getPhoneNumber())) {
                        System.out.println("Wrong number format!");
                    }
                    contacts.add(contact);
                    System.out.println("The record added.");
                    break;
                case "remove":
                    break;
                case "edit":
                    break;
                case "count":
                    System.out.println("The Phone Book has " + contacts.size() + " records.");
                    break;
                case "list":
                    break;
                case "exit":
                    return;
            }
        }
    }

    public void createContact() {

    }
}
