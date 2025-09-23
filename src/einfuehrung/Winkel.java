package einfuehrung;

import java.util.Scanner;

/**
 * Entwickle ein Java-Programm, welches folgende Aufgabenstellung erfüllt:
 *
 * Lies vom Benutzer einen Winkel in Grad ein und gib den Winkel in Radiant aus.
 *
 * Verwende eine formatierte Ausgabe mit vier Nachkommastellen!
 */
public class Winkel {

    public static void main(String[] args) {
        double winkelGrad,winkelRad;
        Scanner sc=new Scanner(System.in);
        // Eingabe
        System.out.print("Winkel in Grad:");
        winkelGrad=sc.nextDouble();
        // Berechnung
        winkelRad = winkelGrad*Math.PI/180.0;
        // Ausgabe
        System.out.printf("Radiant: %.4f\n",winkelRad);
        sc.close();
    }
}
