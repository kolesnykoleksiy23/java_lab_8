package com.education.ztu.oleksiy.task3;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        // task a:
        Predicate<String> isNumeric = str -> {
            try {
                Double.parseDouble(str);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        };
        Predicate<String> nonEmpty = str -> !str.isEmpty();

        String testString = "123";
        boolean result = isNumeric.and(nonEmpty).test(testString);
        System.out.println("Is numeric and non-empty: " + result);


        // task b:
        Consumer<String> startLecture = str -> System.out.println("Пара почалася о 8:30");
        Consumer<String> endLecture = str -> System.out.println("Пара закінчилася о 9:50");
        startLecture.andThen(endLecture).accept("");


        //task c:
        Supplier<String> upperCaseSentence = () -> "Я люблю Java".toUpperCase();
        System.out.println(upperCaseSentence.get());


        // task d:
        Function<String, Integer> productOfNumbers = str -> Arrays.stream(str.split(" "))
                .mapToInt(Integer::parseInt)
                .reduce(1, (a, b) -> a * b);

        String numbers = "1 2 3 4";
        int product = productOfNumbers.apply(numbers);
        System.out.println("Product of numbers: " + product);

    }
}
