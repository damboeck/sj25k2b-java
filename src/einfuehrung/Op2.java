package einfuehrung;

public class Op2 {

    public static void main(String[] args) {
        int x=359, y=32;
        int z = x / y;
        int rest = x % y;
        System.out.printf("%d / %d = %d Rest %d\n",x,y,z,rest);
        double d = x / y;
        double e = (double)x / y;
        System.out.printf("%d / %d = %.4f != %.4f\n",x,y,d,e);
        rest = --x % y++ + x++*--y;
        System.out.printf("%d , %d => %d Rest %d\n",x,y,z,rest);
        int a=3;
        z = ++a + a++;
        System.out.printf("a=%d z=%d\n",a,z);

        // Operatorenreihenfolge
        x=100;
        y=200;
        a=30;
        z = x*y/a;
        System.out.printf("z=%d\n",z);

    }
}
