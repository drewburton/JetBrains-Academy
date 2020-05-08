class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        if (firstName == null) {
            this.firstName = "";
        } else {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if (lastName == null) {
            this.lastName = "";
        } else {
            this.lastName = lastName;
        }
    }

    public String getFullName() {
        if ("".equals(firstName) && "".equals(lastName)) {
            return "Unknown";
        } else if (firstName == null) {
            return lastName;
        } else if (lastName == null) {
            return firstName;
        } else {
            return firstName + " " + lastName;
        }
    }
}