package day01;

public class ProductMain {
    public static void main(String[] args) {
        System.out.println(Product.getNumberOfProducts());
        // példányosítás nélékül is futtatható
        Product product = new Product("alma");

        System.out.println(product.getName());
        System.out.println(product.getNumberOfProducts());
        System.out.println(Product.getNumberOfProducts());

        Product product1 = new Product("körte");

        System.out.println(product.getName());
        System.out.println(product1.getNumberOfProducts());
        System.out.println(Product.getNumberOfProducts());

        // static: teljesen független az objektumtól
        // a static az osztályé, nem az objektumé
        // elveszítjük az objektum orientáltságot
        // általában szembe megy az objektumorientáltsággal
        //utilitíben vannak ilyenek 8
    }
}
