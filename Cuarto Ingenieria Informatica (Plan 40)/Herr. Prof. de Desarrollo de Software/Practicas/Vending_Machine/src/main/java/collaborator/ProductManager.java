package collaborator;

import model.Product;

import java.util.HashMap;

public class ProductManager {

    HashMap<String, Product> productCatalog;

    public ProductManager() {
        productCatalog = loadProductCatalog();
    }

    private HashMap<String, Product> loadProductCatalog() {
        HashMap<String, Product> newProductCatalog = new HashMap<>();
        newProductCatalog.put("A1", new Product("FontVella 50cl", 0.65));
        return newProductCatalog;
    }

    public boolean isRegistered(String productCodeToCheck){
        return (productCatalog.get(productCodeToCheck) != null);
    }

    public double getPriceOf(String productCodeToCheck) {
        return productCatalog.get(productCodeToCheck).getPrice();
    }
}
