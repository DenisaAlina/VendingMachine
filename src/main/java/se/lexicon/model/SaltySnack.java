package se.lexicon.model;

public class SaltySnack implements ProductInterface{
    private int weight; // in grams

    private int volume;
    private int id;
    private String name;
    private double price;
    private int quantity;


    public SaltySnack( int id, String name, double price, int quantity, int weight) {
        this.weight = weight;
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity=quantity;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }



    public String use() {
        return "Enjoy your " + getName() + "!";
    }

    @Override
    public String examine() {
        return "Salty Snack: " + getName() + " (" + weight + "), Price: " + getPrice() + ", Quantity: " + getQuantity();
    }


}
