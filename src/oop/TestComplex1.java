package oop;

public class TestComplex1 {

    public static void main(String[] args) {
        Complex c1;
        Complex c2,c3,c4;

        c1 = new Complex(2,3);
        c2 = new Complex(3);
        c3 = new Complex(-6,-7);
        c4 = Complex.createImaginary(-9);
        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
        System.out.println("c3 = " + c3);
        System.out.println("c4 = " + c4);
        System.out.println("Realteil von c1: " + c1.getRe());
        System.out.println("c1 = " + c1.toStringPolarDeg());
    }
}
