package org.example;

/**
 * Represents an order item containing a product and its quantity.
 */
public class OrderItem {
    private final Product product;
    private final int quantity;

    /**
     * Creates a new order item with the specified product and quantity.
     *
     * @param product  the product
     * @param quantity the quantity
     */
    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Returns the product of the order item.
     *
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Returns the quantity of the product in the order item.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Calculates the total price of the order item.
     *
     * @return the total price
     */
    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    /**
     * Returns a string representation of the order item.
     *
     * @return a string representation of the order item
     */
    @Override
    public String toString() {
        return String.format(Constants.ITEM_FORMAT, product.getName(), quantity, getTotalPrice());
    }
}
