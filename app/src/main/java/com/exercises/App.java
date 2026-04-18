package com.exercises;

public class App {
    /**
     * The main method is the entry point of the application.
     * It calls the PackageSorter to sort the packages.
     */
    public static void main(String[] args) {
        // call package sorter to sort the packages
        PackageSorter sorter = new PackageSorter();
        System.out.println(sorter.sort(100, 100, 100, 10)); // STANDARD PACKAGE
        System.out.println(sorter.sort(150, 10, 10, 10)); // SPECIAL PACKAGE (bulky)
        System.out.println(sorter.sort(50, 50, 50, 20)); // SPECIAL PACKAGE (heavy)
        System.out.println(sorter.sort(200, 200, 200, 25)); // REJECTED PACKAGE
    }
}
