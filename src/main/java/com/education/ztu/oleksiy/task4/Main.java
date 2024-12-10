package com.education.ztu.oleksiy.task4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Dell", 1500.0, 10),
                new Product("Smartphone", "Apple", 999.99, 20),
                new Product("Tablet", "Samsung", 600.0, 15),
                new Product("Monitor", "LG", 800.0, 5),
                new Product("Keyboard", "Logitech", 50.0, 50)
        );

        System.out.println("Brands:");
        products.stream()
                .map(Product::getBrand)
                .distinct()
                .forEach(System.out::println);

        System.out.println("Products with price < 1000:");
        products.stream()
                .filter(p -> p.getPrice() < 1000)
                .limit(2)
                .forEach(System.out::println);

        int totalCount = products.stream()
                .mapToInt(Product::getCount)
                .sum();
        System.out.println("Total count of products: " + totalCount);

        Map<String, List<Product>> groupedByBrand = products.stream()
                .collect(Collectors.groupingBy(Product::getBrand));
        System.out.println("Products grouped by brand:");
        groupedByBrand.forEach((brand, productList) -> {
            System.out.println(brand + ": " + productList);
        });

        Product[] sortedByPrice = products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .toArray(Product[]::new);
        System.out.println("Products sorted by price:");
        Arrays.stream(sortedByPrice).forEach(System.out::println);
    }
}
