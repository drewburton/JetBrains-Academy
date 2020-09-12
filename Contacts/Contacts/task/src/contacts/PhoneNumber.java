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
/*
    1. The phone number should be split into groups using a space or dash. One group is also possible.
    2. Before the first group, there may or may not be a plus symbol.
    3. The first group or the second group can be wrapped in parentheses, but there should be no more than
     one group which is wrapped in parentheses. There may be no groups wrapped in parentheses.
    4. A group can contain numbers, uppercase, and lowercase English letters. A group should be at least 2
     symbols in length. But the first group may be only one symbol in length.
 */
    private boolean isValidNumber(String number) {
        return true;
    }
}
