package se.lexicon;


import se.lexicon.model.ProductInterface;
import se.lexicon.model.VendingMachine;
import se.lexicon.model.VendingMachineImpl;


public class App {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachineImpl();

        // Adding currency
        vendingMachine.addCurrency(20);

        // Requesting a product
        ProductInterface product = vendingMachine.request(2);
        System.out.println("Bought: " + vendingMachine.getDescription(product.getId()));
        System.out.println("Examine: " + product.examine());
        System.out.println("Use: " + product.use());

        // Checking balance
        System.out.println("Balance: " + vendingMachine.getBalance());

        // Ending session and getting change
        System.out.println("Returning: " + vendingMachine.endSession());
    }

}


