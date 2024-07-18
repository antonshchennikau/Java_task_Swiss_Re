package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReceiptTest {
    private Receipt receipt;
    private Product largeCoffee;
    private Product baconRoll;
    private Product extraMilk;
    private Product specialRoast;

    @BeforeEach
    void setUp() {
        receipt = new Receipt();
        largeCoffee = new Product(Constants.LARGE_COFFEE, Constants.LARGE_COFFEE_PRICE);
        baconRoll = new Product(Constants.BACON_ROLL, Constants.BACON_ROLL_PRICE);
        extraMilk = new Product(Constants.EXTRA_MILK, Constants.EXTRA_MILK_PRICE);
        specialRoast = new Product(Constants.SPECIAL_ROAST_COFFEE, Constants.SPECIAL_ROAST_COFFEE_PRICE);
    }

    @Test
    void testAddItem() {
        receipt.addItem(new OrderItem(largeCoffee, 1));
        assertEquals(1, receipt.getItems().size());
        assertEquals(3.55, receipt.getTotalPrice(), 0.001);
    }

    @Test
    void testFifthBeverageFree() {
        for (int i = 0; i < 5; i++) {
            receipt.addItem(new OrderItem(largeCoffee, 1));
        }
        receipt.applyDiscounts();
        assertEquals(4 * Constants.LARGE_COFFEE_PRICE, receipt.getTotalPrice(), 0.001);
    }

    @Test
    void testFreeExtraWithSnack() {
        receipt.addItem(new OrderItem(largeCoffee, 1));
        receipt.addItem(new OrderItem(baconRoll, 1));
        receipt.addItem(new OrderItem(extraMilk, 1));
        receipt.applyDiscounts();
        assertEquals(Constants.LARGE_COFFEE_PRICE + Constants.BACON_ROLL_PRICE, receipt.getTotalPrice(), 0.001);
    }

    @Test
    void testMultipleDiscounts() {
        for (int i = 0; i < 5; i++) {
            receipt.addItem(new OrderItem(largeCoffee, 1));
        }
        receipt.addItem(new OrderItem(baconRoll, 1));
        receipt.addItem(new OrderItem(extraMilk, 1));
        receipt.addItem(new OrderItem(specialRoast, 1));
        receipt.applyDiscounts();
        assertEquals(4 * Constants.LARGE_COFFEE_PRICE + Constants.BACON_ROLL_PRICE + Constants.SPECIAL_ROAST_COFFEE_PRICE, receipt.getTotalPrice(), 0.001);
    }

    @Test
    void testNoDiscounts() {
        receipt.addItem(new OrderItem(largeCoffee, 1));
        receipt.addItem(new OrderItem(baconRoll, 1));
        receipt.applyDiscounts();
        assertEquals(Constants.LARGE_COFFEE_PRICE + Constants.BACON_ROLL_PRICE, receipt.getTotalPrice(), 0.001);
    }

    @Test
    void testNullOrderItem() {
        receipt.addItem(null);
        assertEquals(0, receipt.getItems().size());
    }
}
