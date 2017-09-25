package shopping;

import java.util.LinkedHashMap;
import java.util.Map;

import static shopping.PriceCalculator.calculateTotalDiscountsFor;
import static shopping.PriceCalculator.calculateTotalPriceFor;

public class ShoppingCart {
    private Map<Product, Integer> productsInCart = new LinkedHashMap<>();

    public int getTotalProducts() {
        return productsInCart.size();
    }

    public void add(Product product, int quantity) {
        productsInCart.put(product, quantity);
    }

    public Map<Product, Integer> getProducts() {
        return productsInCart;
    }

    public int getTotalPrice() {
        return calculateTotalPriceFor(productsInCart);
    }

    public int getTotalDiscounts() {
        return calculateTotalDiscountsFor(productsInCart);
    }
}