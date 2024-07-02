package se.lexicon.model;

public class SaltySnack extends Product{
    private int weight; // in grams

    public SaltySnack(String id, String name, double price, int weight, int quantity) {
        super(id, name, price, quantity);
        this.weight = weight;
    }
    @Override
    public String examine() {
        return "Salty Snack: " + getName() + " (" + weight + "), Price: " + getPrice() + ", Quantity: " + getQuantity();
    }

    public String use() {
        return "Enjoy your " + getName() + "!";
    }

}
