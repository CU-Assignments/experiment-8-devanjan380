import java.util.*;
import java.util.stream.Collectors;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

public class ProductProcessor {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1200.0),
            new Product("Smartphone", "Electronics", 800.0),
            new Product("TV", "Electronics", 1500.0),
            new Product("Sofa", "Furniture", 700.0),
            new Product("Table", "Furniture", 250.0),
            new Product("Chair", "Furniture", 150.0),
            new Product("Jeans", "Clothing", 50.0),
            new Product("T-Shirt", "Clothing", 20.0),
            new Product("Jacket", "Clothing", 120.0)
        );

        Map<String, List<Product>> productsByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory));

        System.out.println("Products Grouped by Category:");
        productsByCategory.forEach((category, productList) -> 
            System.out.println(category + ": " + productList)
        );

        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
            .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
            ));

        System.out.println("\nMost Expensive Product in Each Category:");
        mostExpensiveByCategory.forEach((category, product) -> 
            System.out.println(category + ": " + product.orElse(null))
        );

        double averagePrice = products.stream()
            .mapToDouble(Product::getPrice)
            .average()
            .orElse(0.0);

        System.out.println("\nAverage Price of All Products: $" + String.format("%.2f", averagePrice));
    }
}
