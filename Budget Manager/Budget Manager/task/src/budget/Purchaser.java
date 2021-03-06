package budget;

import java.util.ArrayList;
import java.util.Scanner;

public class Purchaser {
    protected ArrayList<Purchase> purchases;
    protected Scanner scanner;
    public enum Category { FOOD, CLOTHES, ENTERTAINMENT, OTHER, ALL }
    protected enum SortType { ALL, FOOD, CLOTHES, ENTERTAINMENT, OTHER }

    public Purchaser(Scanner scanner) {
        this.scanner = scanner;
        purchases = new ArrayList<>();
    }

    public Purchaser(Scanner scanner, ArrayList<Purchase> purchases) {
        this.scanner = scanner;
        this.purchases = purchases;
    }

    public void sort(SortType type) {
        purchases.sort((purchase, t1) -> {
            switch (type) {
                case FOOD:
                    return compareCategory(purchase, t1, Category.FOOD);
                case OTHER:
                    return compareCategory(purchase, t1, Category.OTHER);
                case CLOTHES:
                    return compareCategory(purchase, t1, Category.CLOTHES);
                case ENTERTAINMENT:
                    return compareCategory(purchase, t1, Category.ENTERTAINMENT);
                case ALL:
                    if (purchase.getPrice() > t1.getPrice()) {
                        return -1;
                    } else if (purchase.getPrice() < t1.getPrice()) {
                        return 1;
                    }
                    return 0;
            }
            return 0;
        });
    }

    private int compareCategory(Purchase purchase, Purchase t1, Category category) {
        if (purchase.getCategory() == category &&
                t1.getCategory() != category) {
            return 1;
        } else if (purchase.getCategory() != category &&
                t1.getCategory() == category) {
            return -1;
        } else if (purchase.getPrice() > t1.getPrice()) {
            return -1;
        } else if (purchase.getPrice() < t1.getPrice()) {
            return 1;
        } else {
            return 0;
        }
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

    protected void showCategoryPurchases(Category category) {
        switch (category) {
            case FOOD: System.out.println("Food:");
                break;
            case ENTERTAINMENT: System.out.println("Entertainment:");
                break;
            case CLOTHES: System.out.println("Clothes:");
                break;
            case OTHER: System.out.println("Other");
                break;
            case ALL: System.out.println("All:");
                break;
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

    protected Category getCategory(boolean allOption) {
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
