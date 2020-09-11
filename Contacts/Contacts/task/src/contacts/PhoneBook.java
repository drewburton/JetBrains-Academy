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

    public void createContact() {
        System.out.println("Enter the name of the person:");
        String firstName = scanner.nextLine();

        System.out.println("Enter the surname of the person:");
        String lastName = scanner.nextLine();

        System.out.println("Enter the number:");
        String number = scanner.nextLine();

        contacts.add(new Contact(firstName, lastName, number));
        System.out.println("A record created!");
    }
}
