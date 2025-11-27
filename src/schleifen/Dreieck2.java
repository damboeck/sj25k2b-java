package schleifen;

public class Dreieck2 {


    /**
     * Diese Methode soll ein Dreieck der angegebenen Größe in der Konsole ausgeben.
     * Es sollen x als Zeichen verwendet werden.
     * Beispiel für size = 4:
     *    x
     *   xx
     *  xxx
     * xxxx
     * @param size Die Größe des Dreiecks (Anzahl der Zeilen)
     */
    public static void dreieck2(int size) {
        for (int z=0;z<size;z++) {
            for (int s=0;s<size-z-1;s++)
                System.out.print(" ");
            for (int s=0;s<z+1;s++) {
                System.out.print("x");
            }
            System.out.println();
        }
    }

    public static void dreieck2_v2(int size) {
        for (int z=0;z<size;z++) {
            for (int s = 0; s < size; s++)
                System.out.print(z < size-s-1 ? " " : "x");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        dreieck2_v2(4);
        System.out.println();
        dreieck2_v2(7);
        System.out.println();
        dreieck2(4);
        System.out.println();
        dreieck2(7);
    }
}
