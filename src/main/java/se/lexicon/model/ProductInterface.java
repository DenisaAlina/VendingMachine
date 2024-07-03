package se.lexicon.model;

public interface ProductInterface {
    int getId();

    String getName();

    double getPrice();

    int getQuantity();

    void setQuantity(int quantity);

    void setName(String name);

    void setPrice(double price);

    String examine();

    String use();
}
