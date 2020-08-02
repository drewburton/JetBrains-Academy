package budget;

import java.util.ArrayList;
import java.util.Scanner;

public class Analyzer extends Purchaser {
    public Analyzer(Scanner scanner) {
        super(scanner);
    }

    public Analyzer(Scanner scanner, ArrayList<Purchase> purchases) {
        super(scanner, purchases);
    }

    public void analyze() {
        while (true) {
            System.out.println("How do you want to sort?");
            System.out.println("1) Sort all purchases");
            System.out.println("2) Sort by type");
            System.out.println("3) Sort certain type");
            System.out.println("4) Back");

            int option = Integer.parseInt(scanner.nextLine());
            System.out.println();
            switch (option) {
                case 1:
                    sort(SortType.ALL);
                    showCategoryPurchases(Category.ALL);
                    System.out.println();
                    break;
                case 2:
                    showTypes();
                    System.out.println();
                    break;
                case 3:
                    Category category = getCategory(false);
                    switch (category) {
                        case FOOD:
                            sort(SortType.FOOD);
                            break;
                        case CLOTHES:
                            sort(SortType.CLOTHES);
                            break;
                        case ENTERTAINMENT:
                            sort(SortType.ENTERTAINMENT);
                            break;
                        case OTHER:
                            sort(SortType.OTHER);
                            break;
                    }
                    if (purchases.size() != 0) {
                        showCategoryPurchases(category);
                    } else {
                        System.out.println("Purchase list is empty!");
                    }
                    System.out.println();
                    break;
                case 4:
                    return;
            }
        }
    }

    private void showTypes() {
        double food = 0, entertainment = 0, clothes = 0, other = 0;
        for (Purchase purchase : purchases) {
            switch(purchase.getCategory()) {
                case ENTERTAINMENT:
                    entertainment += purchase.getPrice();
                    break;
                case CLOTHES:
                    clothes += purchase.getPrice();
                    break;
                case OTHER:
                    other += purchase.getPrice();
                    break;
                case FOOD:
                    food += purchase.getPrice();
                    break;
            }
        }

        System.out.println("Types:");
        System.out.println("Food - $" + String.format("%.2f", food));
        System.out.println("Entertainment - $" + String.format("%.2f", entertainment));
        System.out.println("Clothes - $" + String.format("%.2f", clothes));
        System.out.println("Other - $" + String.format("%.2f", other));
        System.out.println("Total sum: $" + String.format("%.2f", food + entertainment + clothes + other));
    }
}
