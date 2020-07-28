package budget;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    private Scanner scanner;
    private double balance;
    private Purchaser purchaser;

    public Manager() {
        scanner = new Scanner(System.in);
        purchaser = new Purchaser(scanner);
    }

    public void processActions() {
        while (true) {
            System.out.println("Choose your action:");
            System.out.println("1) Add income");
            System.out.println("2) Add purchase");
            System.out.println("3) Show list of purchases");
            System.out.println("4) Balance");
            System.out.println("0) Exit");

            int option = Integer.parseInt(scanner.nextLine());
            System.out.println();
            switch (option) {
                case 1:
                    addIncome();
                    break;
                case 2:
                    balance -= purchaser.addPurchase();
                    break;
                case 3:
                    purchaser.showPurchases();
                    break;
                case 4:
                    showBalance();
                    break;
                case 0:
                    System.out.println("Bye!");
                    return;
            }
        }
    }

    private void addIncome() {
        System.out.println("Enter income:");
        double income = Double.parseDouble(scanner.nextLine());
        balance += income;
        System.out.println();
    }

    private void showBalance() {
        System.out.println("Balance: $" + balance + "\n");
    }
}
