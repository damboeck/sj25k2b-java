package schleifen;

public class Baum {

    public static void baum(int size) {
        System.out.println(" ".repeat(size-2)+"*");
        for (int z=1;z<size-1;z++)
            System.out.println(" ".repeat(size-2-z)+"/"+"xO".repeat(z-1)+"x\\");
        System.out.println(" ".repeat(size-2)+"|");
    }

    public static void main(String[] args) {
        baum(5);
        baum(10);
    }
}
