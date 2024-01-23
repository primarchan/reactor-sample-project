package org.example;

public class Main {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();

        // publisher.startFlux().subscribe(System.out::println);
        // publisher.startMono1().subscribe(System.out::println);
        publisher.startMono2().subscribe(System.out::println);
    }

}