package budget;

import java.util.ArrayList;
import java.util.Scanner;

public class Purchaser {
    private ArrayList<Purchase> purchases;
    private Scanner scanner;
    public enum Category { FOOD, CLOTHES, ENTERTAINMENT, OTHER, ALL };

    public Purchaser(Scanner scanner) {
        this.scanner = scanner;
        purchases = new ArrayList<>();
    }

    public Purchaser(Scanner scanner, ArrayList<Purchase> purchases) {
        this.scanner = scanner;
        this.purchases = purchases;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Purchase purchase : purchases) {
            builder.append(purchase.getCategory() + " " + purchase.toString() + "\n");
        }
        return builder.toString();
    }

    public double addPurchase() {
        double total = 0;
        Category category = getCategory(false);
        while (category != null) {
            System.out.println("Enter purchase name:");
            String name = scanner.nextLine();
            System.out.println("Enter its price:");
            double price = Double.parseDouble(scanner.nextLine());

            purchases.add(new Purchase(name, price, category));
            System.out.println("Purhcase was added\n");
            total += price;

            category = getCategory(false);
        }
        return total;
    }

    public void showPurchases() {
        if (purchases.size() == 0) {
            System.out.println("Purchase list is empty\n");
        } else {
            Category category = getCategory(true);
            while (category != null) {
                showCategoryPurchases(category);
                category = getCategory(true);
            }
        }
    }

    private void showCategoryPurchases(Category category) {
        switch (category) {
            case FOOD: System.out.println("Food:");
            case ENTERTAINMENT: System.out.println("Entertainment:");
            case CLOTHES: System.out.println("Clothes:");
            case OTHER: System.out.println("Other");
            case ALL: System.out.println("All:");
        }

        double categoryCost = 0;
        for (Purchase purchase : purchases) {
            if (purchase.getCategory() == category || category == Category.ALL) {
                System.out.println(purchase);
                categoryCost += purchase.getPrice();
            }
        }

        if (categoryCost > 0) {
            System.out.println("Total sum: $" + categoryCost + "\n");
        } else {
            System.out.println("Purchase list is empty!");
        }
    }

    private Category getCategory(boolean allOption) {
        System.out.println("Choose the type of purchase");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");
        if (allOption) {
            System.out.println("5) All");
            System.out.println("6) Back");
        } else {
            System.out.println("5) Back");
        }

        int option = Integer.parseInt(scanner.nextLine());
        System.out.println();
        if (!allOption) {
            switch (option) {
                case 1:
                    return Category.FOOD;
                case 2:
                    return Category.CLOTHES;
                case 3:
                    return Category.ENTERTAINMENT;
                case 4:
                    return Category.OTHER;
                default:
                    return null;
            }
        } else {
            switch (option) {
                case 1:
                    return Category.FOOD;
                case 2:
                    return Category.CLOTHES;
                case 3:
                    return Category.ENTERTAINMENT;
                case 4:
                    return Category.OTHER;
                case 5:
                    return Category.ALL;
                default:
                    return null;
            }
        }
    }
}
