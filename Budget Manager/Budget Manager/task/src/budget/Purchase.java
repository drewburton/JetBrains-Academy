package budget;

public class Purchase {
    private String name;
    private double price;
    private Purchaser.Category category;

    public Purchase(String name, double price, Purchaser.Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        String priceString = String.format("%.2f", price);
        return name + " $" + priceString;
    }

    public Purchaser.Category getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}
