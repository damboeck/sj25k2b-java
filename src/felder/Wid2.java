package felder;

import java.util.Scanner;

public class Wid2 {

    public static double[] einlesenVonWiderstandswerten() {
        double[] r;
        int anzahl;
        Scanner sc = new Scanner(System.in);
        System.out.print("Anzahl der Widerstände: ");
        anzahl = sc.nextInt();
        r = new double[anzahl];
        for (int i = 0; i < anzahl; i++) {
            System.out.printf("Widerstand R%d in Ohm: ", i + 1);
            r[i] = sc.nextDouble();
        }
        return r;
    }

    public static void main(String[] args) {
        double[] r;
        double rser,rpar;
        do {
            r = einlesenVonWiderstandswerten();
            rser = Widerstand.gesamtWiderstandSerie(r);
            rpar = Widerstand.gesamtWiderstandParallel(r);
            System.out.printf("Gesamtwiderstand in Serie: %.3f Ohm\n", rser);
            System.out.printf("Gesamtwiderstand Parallel: %.3f Ohm\n", rpar);
        } while(wiederholen());
    }

    /**
     * Fragt den Benutzer, ob er die Berechnung wiederholen möchte.
     * @return true, wenn der Benutzer "j" eingibt, sonst false.
     */
    public static boolean wiederholen() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nochmal (j/n)? ");
        String eingabe = sc.nextLine();
        return eingabe.equalsIgnoreCase("j");
    }
}
