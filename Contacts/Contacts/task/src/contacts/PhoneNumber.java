package contacts;

public class PhoneNumber {
    private String phoneNumber;

    public PhoneNumber(String phoneNumber) {
        this.phoneNumber = isValidNumber(phoneNumber) ? phoneNumber : "";
    }

    public PhoneNumber() {
        phoneNumber = "";
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean hasPhoneNumber() {
        return phoneNumber != "";
    }

    // todo implement
    private boolean isValidNumber(String number) {
        return false;
    }
}
