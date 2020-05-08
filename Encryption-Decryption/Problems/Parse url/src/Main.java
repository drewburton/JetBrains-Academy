import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String url = scanner.nextLine();
        GetParameters(url);
    }

    public static void GetParameters(String url) {
        String password = "";

        String[] separatedUrl = url.split("\\?");
        String[] parameters = (separatedUrl[1]).split("&");
        for (String parameter : parameters) {
            String[] nameValue = parameter.split("=");
            if (nameValue.length <= 1)
                System.out.println(nameValue[0] + " : not found");
            else {
                System.out.println(nameValue[0] + " : " + nameValue[1]);
                if (nameValue[0].equals("pass"))
                    password = nameValue[1];
            }
        }
        if (!password.equals(""))
            System.out.println("password : " + password);
    }
}