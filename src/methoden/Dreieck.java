package methoden;

import java.util.Scanner;

public class Dreieck {

    /** Seitenlängen des Dreiecks, als globale Variablen */
    public static double a,b,c;

    /** Liest die drei Seitenlängen eines Dreiecks vom Benutzer ein */
    public static void seitenEinlesen() {
        Scanner sc = new Scanner(System.in);
        System.out.print("1. Seite :");
        a = sc.nextDouble();
        System.out.print("2. Seite :");
        b = sc.nextDouble();
        System.out.print("3. Seite :");
        c = sc.nextDouble();
        sc.close();
    }

    /** Sortiert die Seitenlängen a,b,c so dass a <= b <= c gilt */
    public static void sortiereSeiten() {
        double h;
        if (a > b) { h = a; a = b; b = h; }
        if (a > c) { h = a; a = c; c = h; }
        // Nun ist a sicher die kleinste Seite
        if (b > c) { h = b; b = c; c = h; }
        // Nun ist auch b <= c
    }

    /** Bestimmt die Art des Dreiecks anhand der Seitenlängen a,b,c */
    public static void bestimmeDreieck() {
        double tol=0.1; // Toleranz in Prozent
        if (equals(a,c,tol)) System.out.println("gleichseitiges Dreieck");
        else if (equals(c,Math.sqrt(a*a+b*b),tol) && equals(a,b,tol)) System.out.println("gleichschenkelig rechtwinkeliges Dreieck");
        else if (equals(a,b,tol) || equals(b,c,tol)) System.out.println("gleichschenkliges Dreieck");
        else if (equals(c,Math.sqrt(a*a+b*b),tol)) System.out.println("rechtwinkeliges Dreieck");
        else if (a+b>c) System.out.println("allgemeines Dreieck");
        else System.out.println("kein Dreieck");
    }

    /** Vergleicht zwei Gleitkommazahlen auf Gleichheit unter Berücksichtigung einer Toleranz
     * @param a erste Zahl
     * @param b zweite Zahl
     * @param tol Toleranz in Prozent
     * @return true, wenn a und b innerhalb der Toleranz gleich sind
     */
    public static boolean equals(double a, double b, double tol) {
        double aR = Math.abs(a-b)/Math.max(Math.abs(a),Math.abs(b))*100.;
        boolean result = aR < tol;
        return result;
    }

    public static void main(String[] args) {
        seitenEinlesen();
        sortiereSeiten();
        System.out.printf("a=%.5f b=%.5f c=%.5f\n",a,b,c);
        bestimmeDreieck();
    }
}
