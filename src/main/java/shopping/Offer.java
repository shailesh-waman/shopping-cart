package shopping;

class Offer {
    private final int onQuantity;
    private final int freeQuantity;

    Offer(int onQuantity, int freeProduct) {
        this.onQuantity = onQuantity;
        this.freeQuantity = freeProduct;
    }

    public int getOnQuantity() {
        return onQuantity;
    }

    public int getFreeQuantity() {
        return freeQuantity;
    }
}
