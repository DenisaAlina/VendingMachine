package se.lexicon.model;

public class Candy extends Product{
    private String flavor;

    public Candy(String id, String name, double price, String flavor, int quantity) {
        super(id, name, price,quantity);
        this.flavor = flavor;
    }
    @Override
    public String examine() {
        return "Candy: " + getName() + " (" + flavor + "), Price: " + getPrice() + ", Quantity: " + getQuantity();
    }

    public String use() {
        return "Enjoy your " + getName() + "!";
    }


}
