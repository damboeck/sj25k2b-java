package verzweigungen;

import java.util.Scanner;

/**
 * Prüfe ob zwei Seiten zu einem Rechteck oder einem Quadrat gehören
 */
public class Rechteck {

    public static void main(String[] args) {
        double a,b;
        Scanner sc=new Scanner(System.in);

        System.out.print("1. Seite :");
        a=sc.nextDouble();
        System.out.print("2. Seite :");
        b=sc.nextDouble();

        // Überprüfung
        if (a==b)  System.out.println("Das ist ein Quadrat!");
        else       System.out.println("Das ist ein Rechteck!");

        // Mit Klammern
        if (a==b)  {
            System.out.println("Das ist ein Quadrat!");
        } else {
            System.out.println("Das ist ein Rechteck!");
        }

        // Als Spagetticode
        if (a==b)  System.out.println("Das ist ein Quadrat!"); else System.out.println("Das ist ein Rechteck!");

        // Finale
        sc.close();
    }

}
