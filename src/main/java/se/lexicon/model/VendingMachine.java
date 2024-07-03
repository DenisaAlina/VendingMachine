package se.lexicon.model;

public interface VendingMachine {
    void addCurrency(int amount);
    ProductInterface request(int productId);
    int endSession();
    String getDescription(int productId);
    int getBalance();
    String[] getProducts();

}
