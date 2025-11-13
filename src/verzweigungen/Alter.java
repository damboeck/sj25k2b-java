package verzweigungen;

import java.util.Scanner;

/**
 * Bestimme die Personenart auf Grund des Alters
 */
public class Alter {

    public static void main(String[] args) {
        int alter;
        Scanner sc = new Scanner(System.in);

        System.out.print("Alter:");
        alter = sc.nextInt();

        // Bestimmung;
        if (alter<0)       System.out.println("Du willst mich wohl auf den Arm nehmen!");
        else if (alter<2)  System.out.println("Das ist ein Baby!");
        else if (alter<6)  System.out.println("Das ist ein Kleinkind!");
        else if (alter<13) System.out.println("Du bist ein Kind!");
        else if (alter<18) System.out.println("Du bist ein Teenager!");
        else if (alter<65) System.out.println("Sie sind ein Erwachsener!");
        else               System.out.println("Sie sind ein Pensionist!");

        // Bestimmung mit Klammern
        if (alter<2)       {
            System.out.println("Das ist ein Baby!");
        } else if (alter<6)  {
            System.out.println("Das ist ein Kleinkind!");
        } else if (alter<13) {
            System.out.println("Du bist ein Kind!");
        } else if (alter<18) {
            System.out.println("Du bist ein Teenager!");
        } else if (alter<65) {
            System.out.println("Sie sind ein Erwachsener!");
        } else {
            System.out.println("Sie sind ein Pensionist!");
        }

        // final
        sc.close();
    }
}
