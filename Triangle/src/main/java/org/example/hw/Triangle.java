package org.example.hw;

public class Triangle
{
    public static boolean checkSides(int a, int b, int c) throws Exception {
        if ((a > 0) && (b > 0) && (c > 0)) {
            return ((a + b > c) && (a + c > b) && (b + c > a));
        } else {
            throw new Exception("The sides of a triangle cannot be equal or less then 0");
        }
    }
    public static double measureTriangleSquare(int a, int b, int c) {
        int p = (a + b + c) / 2;
        double S = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        return S;
    }
}