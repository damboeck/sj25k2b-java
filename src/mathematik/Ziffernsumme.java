package mathematik;

public class Ziffernsumme {

    /**
     * Berechnet die Ziffernsumme einer Zahl
     * @param z Zahl
     * @return  Ziffernsumme der Zahl
     */
    public static int zs(int z) {
        int zs;
        for (zs=0;z!=0;z/=10) {
            zs += z % 10;
        }
        return zs;
    }

    /*public static void main(String[] args) {
        int zahl = 22345;
        int ziffernsumme = zs(zahl);
        System.out.println("Die Ziffernsumme von " + zahl + " ist: " + ziffernsumme);
    }*/

    public static int testCounter=0;
    public static int testFailCounter=0;

    public static void testZs(int zahl, int erwarteteZs) {
        int berechneteZs = zs(zahl);
        if (berechneteZs != erwarteteZs) {
            System.out.println("Fehler bei Ziffernsumme von " + zahl + ": erwartet " + erwarteteZs + ", aber berechnet " + berechneteZs);
            testFailCounter++;
        }
        testCounter++;
    }

    public static void main(String[] args) {
        testZs(22345,16);
        testZs(12345,15);
        testZs(-1456,-16);
        testZs(3648956,41);
        testZs(15,6);
        testZs(0,0);
        testZs(5,5);
        testZs(42,6);
        testZs(99999,45);
        System.out.println("Getestete Fälle: " + testCounter);
        System.out.println("Fehlgeschlagene Tests: " + testFailCounter);
    }

}
