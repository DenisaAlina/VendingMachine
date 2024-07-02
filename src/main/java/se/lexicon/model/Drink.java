package se.lexicon.model;

public class Drink extends Product
{
    private int volume;

    public Drink(String id, String name, double price, int volume, int quantity) {
        super(id, name, price, quantity);
        this.volume = volume;

    }
    @Override
    public String examine() {
        return "Drink: " + getName() + " (" + volume + "), Price: " + getPrice() + ", Quantity: " + getQuantity();
    }

    public String use() {
        return "Enjoy your " + getName() + "!";
    }
    }


