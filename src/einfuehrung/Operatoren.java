package einfuehrung;

public class Operatoren {
    public static void main(String[] args) {
        int x, y, z;
        x = 7;
        y = x++;
        System.out.printf("x=%d y=%d\n", x, y);
        x = 7;
        y = x++ * 3;
        System.out.printf("x=%d y=%d\n", x, y);
        x = 7;
        y = x++ + 3 * x; // 7 + 3*8
        System.out.printf("x=%d y=%d\n", x, y);
        x = 7;
        y = 3 * x + x++; // 3*7 + 7
        System.out.printf("x=%d y=%d\n", x, y);
        x = 7;
        y = ++x + 3 * x; // 8 + 3*8
        System.out.printf("x=%d y=%d\n", x, y);
        x = 7;
        y = 3 * x + ++x; // 3*7 + 8
        System.out.printf("x=%d y=%d\n", x, y);
    }
}
