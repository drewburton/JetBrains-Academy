package budget;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    private Scanner scanner;
    private double balance;
    private Saver saver;
    private Analyzer analyzer;

    public Manager() {
        scanner = new Scanner(System.in);
        saver = new Saver();
        analyzer = new Analyzer(scanner);
    }

    public void processActions() {
        while (true) {
            System.out.println("Choose your action:");
            System.out.println("1) Add income");
            System.out.println("2) Add purchase");
            System.out.println("3) Show list of purchases");
            System.out.println("4) Balance");
            System.out.println("5) Save");
            System.out.println("6) Load");
            System.out.println("7) Analyze (Sort)");
            System.out.println("0) Exit");

            int option = Integer.parseInt(scanner.nextLine());
            System.out.println();
            switch (option) {
                case 1:
                    addIncome();
                    break;
                case 2:
                    balance -= analyzer.addPurchase();
                    break;
                case 3:
                    analyzer.showPurchases();
                    break;
                case 4:
                    showBalance();
                    break;
                case 5:
                    saver.save(analyzer, balance);
                    System.out.println("Purchases were saved!\n");
                    break;
                case 6:
                    ArrayList<Purchase> retrievedPurchases = saver.getPurchases();
                    if (retrievedPurchases != null) {
                        balance = saver.getBalance();
                        analyzer = new Analyzer(scanner, retrievedPurchases);
                        System.out.println("Purchases were loaded!\n");
                    }
                    break;
                case 7:
                    analyzer.analyze();
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
        System.out.println("Income was added!\n");
    }

    private void showBalance() {
        System.out.println("Balance: $" + balance + "\n");
    }
}
