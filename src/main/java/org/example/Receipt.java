package org.example;

import java.util.*;

/**
 * Represents a receipt for an order containing multiple order items.
 */
public class Receipt {
    private final List<OrderItem> items = new ArrayList<>();
    private int totalBeverages = 0;
    private int totalSnacks = 0;

    /**
     * Adds an order item to the receipt.
     *
     * @param item the order item to add
     */
    public void addItem(OrderItem item) {
        if (item != null) {
            items.add(item);
            if (isBeverage(item.getProduct())) {
                totalBeverages += item.getQuantity();
            }
            if (isSnack(item.getProduct())) {
                totalSnacks += item.getQuantity();
            }
        }
    }

    /**
     * Applies discounts to the receipt based on the given rules.
     */
    public void applyDiscounts() {
        int freeBeverages = totalBeverages / 5;
        boolean extraFreeApplied = false;
        boolean snackPurchased = totalSnacks > 0;

        for (int i = 0; i < items.size(); i++) {
            OrderItem item = items.get(i);
            if (freeBeverages > 0 && isBeverage(item.getProduct())) {
                applyFreeBeverageDiscount(i, item, freeBeverages);
                freeBeverages--;
            } else if (snackPurchased && isExtra(item.getProduct()) && !extraFreeApplied) {
                applyFreeExtraDiscount(i, item);
                extraFreeApplied = true;
            }
        }
    }

    private void applyFreeBeverageDiscount(int index, OrderItem item, int remainingFreeBeverages) {
        int freeQuantity = Math.min(item.getQuantity(), remainingFreeBeverages);
        double discountedPrice = item.getProduct().getPrice() * (item.getQuantity() - freeQuantity) / item.getQuantity();
        items.set(index, new OrderItem(new Product(item.getProduct().getName(), discountedPrice), item.getQuantity()));
    }

    private void applyFreeExtraDiscount(int index, OrderItem item) {
        items.set(index, new OrderItem(new Product(item.getProduct().getName(), 0.0), item.getQuantity()));
    }

    private boolean isBeverage(Product product) {
        String name = product.getName();
        return name.equals(Constants.SMALL_COFFEE) ||
                name.equals(Constants.MEDIUM_COFFEE) ||
                name.equals(Constants.LARGE_COFFEE) ||
                name.equals(Constants.ORANGE_JUICE);
    }

    private boolean isSnack(Product product) {
        return product.getName().equals(Constants.BACON_ROLL);
    }

    private boolean isExtra(Product product) {
        String name = product.getName();
        return name.equals(Constants.EXTRA_MILK) ||
                name.equals(Constants.FOAMED_MILK) ||
                name.equals(Constants.SPECIAL_ROAST_COFFEE);
    }

    /**
     * Calculates the total price of the receipt.
     *
     * @return the total price
     */
    public double getTotalPrice() {
        return items.stream().mapToDouble(OrderItem::getTotalPrice).sum();
    }

    /**
     * Returns the list of order items in the receipt.
     *
     * @return the list of order items
     */
    List<OrderItem> getItems() {
        return new ArrayList<>(items);
    }

    /**
     * Returns a string representation of the receipt.
     *
     * @return a string representation of the receipt
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        items.forEach(item -> sb.append(item.toString()).append("\n"));
        sb.append(String.format(Constants.TOTAL_FORMAT, getTotalPrice()));
        return sb.toString();
    }
}
