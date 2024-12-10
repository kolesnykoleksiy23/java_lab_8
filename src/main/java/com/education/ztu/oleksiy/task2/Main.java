package com.education.ztu.oleksiy.task2;

public class Main {
    public static void main(String[] args) {
        Printable printable = () -> System.out.println("Hello, this is a lambda expression!");
        printable.print();
    }
}
