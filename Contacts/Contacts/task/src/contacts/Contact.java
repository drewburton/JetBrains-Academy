package contacts;

public class Contact {
    private String firstName;
    private String lastName;
    private PhoneNumber number;

    private Contact(String firstName, String lastName, PhoneNumber number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
    }

    public PhoneNumber getNumber() {
        return number;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private PhoneNumber number;

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setNumber(String number) {
            this.number = new PhoneNumber(number);
            return this;
        }

        public Contact build() {
            return new Contact(firstName, lastName, number);
        }
    }
}
