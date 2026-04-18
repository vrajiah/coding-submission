package com.exercises;

public class PackageSorter {
    private static final int BULKY_VOLUME = 1_000_000;
    private static final int MAX_DIMENSION = 150;
    private static final int HEAVY_WEIGHT = 20;

    /**
     * Sort the package based on its dimensions and weight.
     * A package is classified as "REJECTED" if it is both bulky and heavy.
     * A package is classified as "SPECIAL" if it is either bulky or heavy (but not both).
     * A package is classified as "STANDARD" if it is neither bulky nor heavy.
     *
     * @param width  the width of the package in centimeters
     * @param height the height of the package in centimeters
     * @param length the length of the package in centimeters
     * @param mass   the mass of the package in kilograms
     * @return the classification of the package ("REJECTED", "SPECIAL", or "STANDARD")
     */
    public static String sort(int width, int height, int length, int mass) {
        if (width <= 0 || height <= 0 || length <= 0 || mass <= 0) return "REJECTED";

        boolean bulky = isBulky(width, height, length);
        boolean heavy = isHeavy(mass);

        if (bulky && heavy) return "REJECTED";
        if (bulky || heavy) return "SPECIAL";
        return "STANDARD";
    }

    private static boolean isBulky(int width, int height, int length) {
        long volume = (long) width * height * length;
        return volume >= BULKY_VOLUME || Math.max(width, Math.max(height, length)) >= MAX_DIMENSION;
    }

    private static boolean isHeavy(int mass) {
        return mass >= HEAVY_WEIGHT;
    }

}
