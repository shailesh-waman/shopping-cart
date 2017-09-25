package shopping;

public class Product {
    private final String name;
    private final int unitPrice;
    private Offer offer;

    public Product(String name, int unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public Offer getOffer() {
        return offer;
    }

    public void addOffer(Offer offer) {
        this.offer = offer;
    }
}
