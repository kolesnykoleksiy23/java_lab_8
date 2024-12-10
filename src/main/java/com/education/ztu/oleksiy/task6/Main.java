package com.education.ztu.oleksiy.task6;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] numbersArray = {2,3,14,5};
        String maxNumber = Arrays.stream(numbersArray)
                .max(Integer::compareTo)
                .map(String::valueOf)
                .orElse("Числа відсутні");
        System.out.println("Максимальне число: " + maxNumber);
    }
}
