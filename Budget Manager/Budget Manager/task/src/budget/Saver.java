package budget;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Saver {
    private File file;

    private double balance;
    private ArrayList<Purchase> purchases;

    public Saver() {
        file = new File("purchases.txt");
        try {
            file.createNewFile();
        } catch(IOException e) {
            System.out.println("failed to create file");
        }
    }

    public void save(Purchaser purchaser, double balance) {
        save(purchaser, balance, true);
    }

    private void save(Purchaser purchaser, double balance, boolean fullDelete) {
        clearSave();
        FileWriter writer;
        try {
            writer = new FileWriter(file);
        } catch (IOException e) {
            System.out.println("failed to find file with writer");
            return;
        }

        try {
            writer.write("Balance: " + balance + "\n");
            writer.write(purchaser.toString());
        } catch (IOException e) {
            System.out.println("failed to save");
        }

        if (fullDelete) {
            purchases = null;
        }

        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double getBalance() {
        if (purchases == null) {
            getFileContents();
        }
        return balance;
    }

    public ArrayList<Purchase> getPurchases() {
        if (purchases == null) {
            getFileContents();
        }
        return purchases;
    }

    public void clearSave() {
        file.delete();
        file = new File("purchases.txt");
    }

    private void getFileContents() {
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("failed to find file with scanner");
            return;
        }

        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("Balance:")) {
                String[] parts = line.split("\\s");
                balance = Double.parseDouble(parts[parts.length - 1]);
            }

            purchases = new ArrayList<>();
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                purchases.add(stringToPurchase(line));
            }

            // because the scanner removed from the file, this adds it back in case the user doesn't save again
            save(new Purchaser(null, purchases), balance, false);
        } else {
            purchases = null;
        }
        scanner.close();
    }

    private Purchase stringToPurchase(String line) {
        // 3 parts "Category Item $Cost"
        String[] parts = line.split("\\s");

        Purchaser.Category category;
        switch(parts[0]) {
            case "FOOD":
                category = Purchaser.Category.FOOD;
                break;
            case "CLOTHES":
                category = Purchaser.Category.CLOTHES;
                break;
            case "ENTERTAINMENT":
                category = Purchaser.Category.ENTERTAINMENT;
                break;
            case "OTHER":
                category = Purchaser.Category.OTHER;
                break;
            default:
                System.out.println("*************** CATEGORY READ FAILED ***************");
                return null;
        }

        StringBuilder name = new StringBuilder();
        for (int i = 1; i < parts.length - 2; i++) {
            name.append(parts[i] + " ");
        }
        name.append(parts[parts.length - 2]);

        double price = Double.parseDouble(parts[parts.length - 1].substring(1));

        return new Purchase(name.toString(), price, category);
    }
}
