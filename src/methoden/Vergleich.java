package methoden;

import java.util.Scanner;

public class Vergleich {

    public static void main(String[] args) {
        double a  = Math.sqrt(3);
        double b;
        double R=0.1; // Genauigkeit in
        double aR;
        Scanner sc = new Scanner(System.in);
        System.out.print("Gib die Wurzel aus drei ein:");
        b  = sc.nextDouble();
        aR = Math.abs(a-b)/Math.max(Math.abs(a),Math.abs(b))*100.;
        if (aR<R) System.out.println("korrekt!");
        else      System.out.println("falsch!");
        sc.close();
    }

}
