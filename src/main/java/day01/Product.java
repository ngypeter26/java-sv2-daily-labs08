package day01;

public class Product {

    private static int numberOfProducts;
    private String name;

    public Product(String name) {
        numberOfProducts++;
        this.name = name;
    }

    public static int getNumberOfProducts() {
        return numberOfProducts;
    }

    public String getName() {
        return name;
    }
}
