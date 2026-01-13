package felder;

import java.util.Scanner;

/**
 * Berechne den Gesamtwiderstand von mehreren Widerständen in Serie und parallel.
 */
public class Widerstand {

    public static void main(String[] args) {
        double[]  r;
        int       anzahl;
        double    rser,rpar;
        Scanner   sc = new Scanner(System.in);

        System.out.print("Anzahl der Widerstand: ");
        anzahl = sc.nextInt();
        r = new double[anzahl];
        for (int i=0; i<r.length; i++) {
            System.out.print("Widerstand R"+(i+1)+" in Ohm: ");
            r[i] = sc.nextDouble();
        }
        // Gesamtwiderstand in Serie
        rser=0.0;
        for (int i=0; i<r.length; i++) {
            double rx = r[i];
            rser += rx;
        }
        System.out.printf("Gesamtwiderstand in Serie: Rser = %.3f \n", rser);
        // Jetzt mit foreach
        rser=0.0;
        for (double rx:r) {
            rser += rx;
        }
        System.out.printf("Gesamtwiderstand in Serie: Rser = %.3f \n", rser);
        // Jetzt als Methode
        rser = gesamtWiderstandSerie(r);
        System.out.printf("Gesamtwiderstand in Serie: Rser = %.3f \n", rser);
        // Gesamtwiderstand in Parallel
        rpar = gesamtWiderstandParallel(r);
        System.out.printf("Gesamtwiderstand in Parallel: Rpar = %.3f \n", rpar);
    }

    /**
     * Berechnet den Gesamtwiderstand von mehreren Widerständen in Serie.
     * @param  r Array mit den Widerstandswerten in Ohm
     * @return Gesamtwiderstand in Ohm
     */
    public static double gesamtWiderstandSerie(double[] r) {
        double rser  = 0.0;
        for (double rx : r) {
            rser += rx;
        }
        return rser;
    }

    /**
     * Berechnet den Gesamtwiderstand von mehreren Widerständen in Parallel.
     * @param  r Array mit den Widerstandswerten in Ohm
     * @return Gesamtwiderstand in Ohm
     */
    public static double gesamtWiderstandParallel(double[] r) {
        double rparInv  = 0.0;
        for (double rx : r) {
            rparInv += 1.0/rx;
        }
        return 1.0/rparInv;
    }

}
