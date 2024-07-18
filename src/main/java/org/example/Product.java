package org.example;

/**
 * Represents a product with a name and a price.
 */
public class Product {
    private final String name;
    private final double price;

    /**
     * Creates a new product with the specified name and price.
     *
     * @param name  the name of the product
     * @param price the price of the product
     */
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Returns the name of the product.
     *
     * @return the name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the price of the product.
     *
     * @return the price of the product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns a string representation of the product.
     *
     * @return a string representation of the product
     */
    @Override
    public String toString() {
        return name + " " + String.format(Constants.PRICE_FORMAT, price);
    }
}
