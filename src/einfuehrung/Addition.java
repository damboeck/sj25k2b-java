package einfuehrung;


import java.util.Scanner;

/**
 * Das Programm soll eine Addition darstellen
 */
public class Addition {

    public static void main(String[] args) {
        int x,y,summe;
        Scanner sc = new Scanner(System.in);
        // Eingabe
        System.out.print("Erste Zahl:");
        x=sc.nextInt();
        System.out.print("Zweite Zahl:");
        y=sc.nextInt();
        // Berechnung (Verarbeitung)
        summe=x+y;
        // Ausgabe
        System.out.printf("Erste Zahl: %d\n",x);
        System.out.printf("Zweite Zahl: %d\n",y);
        System.out.printf("Summe: %d\n",summe);
        sc.close();
    }
}
