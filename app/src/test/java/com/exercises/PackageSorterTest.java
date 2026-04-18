package com.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PackageSorterTest {

    @Test
    void standardPackage() {
        assertEquals("STANDARD", PackageSorter.sort(10, 10, 10, 5));
    }

    @Test
    void bulkyPackage() {
        assertEquals("SPECIAL", PackageSorter.sort(100, 100, 100, 5));
    }

    @Test
    void heavyPackage() {
        assertEquals("SPECIAL", PackageSorter.sort(10, 10, 10, 25));
    }

    @Test
    void rejectedPackage() {
        assertEquals("REJECTED", PackageSorter.sort(100, 100, 100, 25));
    }

    @Test
    void boundaryCaseForBulky() {
        assertEquals("SPECIAL", PackageSorter.sort(100, 100, 100, 19));
    }

    @Test
    void boundaryCaseForHeavy() {
        assertEquals("SPECIAL", PackageSorter.sort(10, 10, 10, 20));
    }

    @Test
    void bulkyByDimension() {
        assertEquals("SPECIAL", PackageSorter.sort(150, 1, 1, 1));
    }

    @Test
    void rejectedByDimension() {
        assertEquals("REJECTED", PackageSorter.sort(150, 1, 1, 20));
    }

    @Test
    void invalidInput() {
        assertEquals("REJECTED", PackageSorter.sort(-10, 10, 10, 5));
    }
}
