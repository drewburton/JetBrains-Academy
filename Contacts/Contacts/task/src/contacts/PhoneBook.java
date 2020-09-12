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
        while (!"exit".equals(action)) {
            System.out.print("Enter action (add, remove, edit, count, list, exit): ");
            action = scanner.nextLine();
            switch (action) {
                case "add":
                    add();
                    break;
                case "remove":
                    remove();
                    break;
                case "edit":
                    edit();
                    break;
                case "count":
                    System.out.println("The Phone Book has " + contacts.size() + " records.");
                    break;
                case "list":
                    list();
                    break;
                default:
                    break;
            }
        }
    }

    private void add() {
        Contact contact = new Contact.Builder()
                .setFirstName(scanner)
                .setLastName(scanner)
                .setNumber(scanner)
                .build();
        contacts.add(contact);
        System.out.println("The record added.");
    }

    private void remove() {
        if (contacts.size() > 0) {
            list();
            System.out.print("Select a record: ");
            int option = Integer.parseInt(scanner.nextLine());
            contacts.remove(option - 1);
            System.out.println("The record removed!");
        } else {
            System.out.println("No records to remove!");
        }
    }

    private void edit() {
        if (contacts.size() == 0) {
            System.out.println("No records to edit!");
            return;
        }

        list();
        System.out.print("Select a record");
        int option = Integer.parseInt(scanner.nextLine());
        System.out.print("Select a field (name, surname, number): ");
        String field = scanner.nextLine();

        Contact.Builder builder = new Contact.Builder();
        switch (field) {
            case "name":
                contacts.set(option - 1, builder.setFirstName(scanner)
                        .setLastName(contacts.get(option - 1).getLastName())
                        .setNumber(contacts.get(option - 1).getNumber())
                        .build());
                break;
            case "surname":
                contacts.set(option - 1, builder.setFirstName(contacts.get(option - 1).getFirstName())
                    .setLastName(scanner)
                    .setNumber(contacts.get(option - 1).getNumber())
                    .build());
                break;
            case "number":
                contacts.set(option - 1, builder.setFirstName(contacts.get(option - 1).getFirstName())
                    .setLastName(contacts.get(option - 1).getLastName())
                    .setNumber(scanner)
                    .build());
        }
        System.out.println("The record updated!");
    }

    private void list() {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
    }
}
