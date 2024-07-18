package org.example;

public class Main {
    public static void main(String[] args) {
        Product largeCoffee = new Product(Constants.LARGE_COFFEE, Constants.LARGE_COFFEE_PRICE);
        Product smallCoffee = new Product(Constants.SMALL_COFFEE, Constants.SMALL_COFFEE_PRICE);
        Product baconRoll = new Product(Constants.BACON_ROLL, Constants.BACON_ROLL_PRICE);
        Product orangeJuice = new Product(Constants.ORANGE_JUICE, Constants.ORANGE_JUICE_PRICE);
        Product extraMilk = new Product(Constants.EXTRA_MILK, Constants.EXTRA_MILK_PRICE);
        Product specialRoast = new Product(Constants.SPECIAL_ROAST_COFFEE, Constants.SPECIAL_ROAST_COFFEE_PRICE);

        OrderItem orderItem1 = new OrderItem(largeCoffee, 1);
        OrderItem orderItem2 = new OrderItem(smallCoffee, 1);
        OrderItem orderItem3 = new OrderItem(baconRoll, 1);
        OrderItem orderItem4 = new OrderItem(orangeJuice, 1);
        OrderItem orderItem5 = new OrderItem(extraMilk, 1);
        OrderItem orderItem6 = new OrderItem(specialRoast, 1);

        Receipt receipt = new Receipt();
        receipt.addItem(orderItem1);
        receipt.addItem(orderItem2);
        receipt.addItem(orderItem3);
        receipt.addItem(orderItem4);
        receipt.addItem(orderItem5);
        receipt.addItem(orderItem6);

        receipt.applyDiscounts();

        System.out.println("INPUT:");
        System.out.println(orderItem1);
        System.out.println(orderItem2);
        System.out.println(orderItem3);
        System.out.println(orderItem4);
        System.out.println(orderItem5);
        System.out.println(orderItem6);
        System.out.println("OUTPUT:");
        System.out.println(receipt);
    }
}




