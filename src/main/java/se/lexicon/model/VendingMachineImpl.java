package se.lexicon.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachineImpl implements VendingMachine{
    private int depositPool;
    private Map<String, Product> products;

    public VendingMachineImpl() {
        depositPool = 0;
        products = new HashMap<>();

        // Adding some products to the vending machine
        products.put("C1", new Candy("C1", "Chocolate Bar", 10, "Chocolate", 15));
        products.put("D1", new Drink("D1", "Soda Can", 15, 330, 10));
    }

    @Override
    public void addCurrency(int amount) {
        int[] validAmounts = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000};
        for (int validAmount : validAmounts) {
            if (amount == validAmount) {
                depositPool += amount;
                return;
            }
        }
        throw new IllegalArgumentException("Invalid currency amount");
    }

    @Override
    public Product request(String productId) {
        Product product = products.get(productId);
        if (product == null) {
            throw new IllegalArgumentException("Product not found");
        }
        if (depositPool >= product.getPrice() && product.getQuantity()>0) {
            depositPool -=  product.getPrice();
            product.setQuantity(product.getQuantity()-1);
            return product;
        } else if(depositPool < product.getPrice()) {
            throw new IllegalStateException("Not enough balance");
        }else{
            throw new IllegalStateException("Product out of stock");
        }
    }

    @Override
    public int endSession() {
        int moneyToReturn = depositPool;
        depositPool = 0;
        return moneyToReturn;
    }

    @Override
    public String getDescription(String productId) {
        Product product = products.get(productId);
        return product != null ? product.examine() : "Product not found";
    }


    @Override
    public int getBalance() {
        return depositPool;
    }

    @Override
    public String[] getProducts() {
        List<String> productList = new ArrayList<>();
        for (Product product : products.values()) {
            productList.add(product.getId() + ", " + product.getName() + ", " + product.getPrice());
        }
        return productList.toArray(new String[0]);
    }
}
