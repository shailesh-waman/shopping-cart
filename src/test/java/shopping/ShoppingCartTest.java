package shopping;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingCartTest {

    private ShoppingCart shoppingCart;

    @Before
    public void setUp() throws Exception {
        shoppingCart = new ShoppingCart();
    }

    @Test
    public void empty_cart() throws Exception {
        assertThat(shoppingCart.getTotalProducts()).isEqualTo(0);
    }

    @Test
    public void non_empty_cart() throws Exception {
        final Product lux = new Product("Lux", 0);
        shoppingCart.add(lux, 10);

        assertThat(shoppingCart.getTotalProducts()).isEqualTo(1);
    }

    @Test
    public void more_than_one_product_in_cart() throws Exception {
        Product lux = new Product("Lux", 0);
        Product denim = new Product("Denim", 0);

        shoppingCart.add(lux, 1);
        shoppingCart.add(denim, 1);

        assertThat(shoppingCart.getTotalProducts()).isEqualTo(2);

        assertThat(shoppingCart.getProducts()).containsKey(lux);
        assertThat(shoppingCart.getProducts()).containsKey(denim);
    }

    @Test
    public void quantity_of_product_in_cart() throws Exception {
        Product carrot = new Product("Carrot", 0);
        shoppingCart.add(carrot, 10);

        assertThat(shoppingCart.getProducts()).containsKey(carrot);
        assertThat(shoppingCart.getProducts().get(carrot)).isEqualTo(10);
    }

    @Test
    public void added_product_in_cart_having_price() throws Exception {
        Product carrot = new Product("Carrot", 10);
        shoppingCart.add(carrot, 10);

        assertThat(shoppingCart.getProducts()).containsKey(carrot);
    }

    @Test
    public void get_total_price_of_products_in_cart() throws Exception {
        Product dove = new Product("Dove", 30);
        shoppingCart.add(dove, 5);

        assertThat(shoppingCart.getTotalPrice()).isEqualTo(150);

        Product lux = new Product("Lux", 10);
        shoppingCart.add(lux, 10);

        assertThat(shoppingCart.getTotalPrice()).isEqualTo(250);
    }

    @Test
    public void buy_2_get_1_discounts_for_products_in_cart() throws Exception {
        Product dove = new Product("Dove", 30);
        Offer buyTwoGetOne = new Offer(2, 1);

        dove.addOffer(buyTwoGetOne);

        shoppingCart.add(dove, 3);

        assertThat(shoppingCart.getTotalPrice()).isEqualTo(60);
        assertThat(shoppingCart.getTotalDiscounts()).isEqualTo(30);

        shoppingCart.add(dove, 5);

        assertThat(shoppingCart.getTotalPrice()).isEqualTo(120);
        assertThat(shoppingCart.getTotalDiscounts()).isEqualTo(30);
    }

    @Test
    public void offer_and_no_offer_for_products_in_cart() throws Exception {
        Product dove = new Product("Dove", 30);
        Offer buyTwoGetOne = new Offer(2, 1);
        dove.addOffer(buyTwoGetOne);

        Product axeDeo = new Product("Axe Deo", 100);


        shoppingCart.add(dove, 3);
        shoppingCart.add(axeDeo, 2);

        assertThat(shoppingCart.getTotalPrice()).isEqualTo(260);
        assertThat(shoppingCart.getTotalDiscounts()).isEqualTo(30);
    }
}
