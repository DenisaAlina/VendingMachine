package se.lexicon.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachineImpl implements VendingMachine{
    private int depositPool =0;
    private List< ProductInterface> products=new ArrayList<>();

    public VendingMachineImpl() {
        // Adding some products to the vending machine
        products.add(new Candy(1, "Chocolate Bar", 10, 12, "strawberry"));
        products.add(new Drink(2, "Soda Can", 15, 330, 10));
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
    public ProductInterface request(int productId) {
        for (ProductInterface product : products) {
            if (product.getId()==productId ) {
                if (depositPool >= product.getPrice()) {
                    depositPool -= product.getPrice();
                    return product;
                } else {
                    throw new IllegalArgumentException("Not enough balance");
                }
            }
        }
        throw new IllegalArgumentException("Product not found");
    }


    @Override
    public int endSession() {
        int moneyToReturn = depositPool;
        depositPool = 0;
        return moneyToReturn;
    }


   @Override
   public String getDescription(int productId) {
       for (ProductInterface product : products) {
           if (product.getId() == productId) {
               return product != null ? product.examine() : "Product not found";
           }
       }
       return "Product not found";
   }

    @Override
    public int getBalance() {
        return depositPool;
    }



    public String[] getProducts() {
        String[] productList = new String[products.size()];
        for (int i = 0; i < products.size(); i++) {
            ProductInterface product = products.get(i);
            productList[i] = "ID: " + product.getId() + ", Name: " + product.getName() + ", Price: " + product.getPrice();
        }
        return productList;
    }
}
