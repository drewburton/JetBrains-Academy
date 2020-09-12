package contacts;

import java.util.Scanner;

public class Contact {
    private String firstName;
    private String lastName;
    private PhoneNumber number;

    private Contact(String firstName, String lastName, PhoneNumber number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public PhoneNumber getNumber() {
        return number;
    }

    @Override
    public String toString() {
        if ("".equals(number.getPhoneNumber())) {
            return firstName + " " + lastName + ", [no number]";
        }
        return firstName + " " + lastName + ", " + number.getPhoneNumber();
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private PhoneNumber number;

        public Builder setFirstName(Scanner scanner) {
            System.out.print("Enter the name: ");
            firstName = scanner.nextLine();
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(Scanner scanner) {
            System.out.print("Enter the surname: ");
            lastName = scanner.nextLine();
            return this;
        }

        public Builder setLastName(String lastname) {
            this.lastName = lastname;
            return this;
        }

        public Builder setNumber(Scanner scanner) {
            System.out.print("Enter the number: ");
            number = new PhoneNumber(scanner.nextLine());
            return this;
        }

        public Builder setNumber(PhoneNumber number) {
            this.number = number;
            return this;
        }

        public Contact build() {
            return new Contact(firstName, lastName, number);
        }
    }
}
