package shopping;

import java.util.Map;

class PriceCalculator {

    private static final int NO_DISCOUNT = 0;

    static int calculateTotalPriceFor(Map<Product, Integer> productsInCart) {

        return productsInCart.entrySet().stream()
                .mapToInt(productDetails -> {
                    Product product = productDetails.getKey();
                    Integer quantity = productDetails.getValue();
                    return calculatePriceFor(product, quantity);
                })
                .sum();
    }

    static int calculateTotalDiscountsFor(Map<Product, Integer> productsInCart) {
        return productsInCart.entrySet().stream()
                .mapToInt(productDetails -> {
                    Product product = productDetails.getKey();
                    Integer quantity = productDetails.getValue();
                    return calculateDiscountsFor(product, quantity);
                })
                .sum();
    }

    private static int calculatePriceFor(Product product, int quantity) {
        int totalPrice = product.getUnitPrice() * quantity;
        int discount = calculateDiscountsFor(product, quantity);

        return totalPrice - discount;
    }

    private static int calculateDiscountsFor(Product product, int quantity) {
        Offer offer = product.getOffer();

        if (offer == null) {
            return NO_DISCOUNT;
        }

        return product.getUnitPrice() * calculateOfferedProducts(quantity, offer);
    }

    private static int calculateOfferedProducts(int quantity, Offer offer) {
        int offerOnQuantity = offer.getOnQuantity();
        int freeQuantity = offer.getFreeQuantity();
        int numberOfProducts = quantity % offerOnQuantity;

        return freeQuantity * numberOfProducts;
    }
}
