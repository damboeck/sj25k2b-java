package verzweigungen;

import methoden.Dreieck;

public class Demo01 {

    public static void main(String[] args) {
        double x=Math.sqrt(2.5*2.5+3*3);
        double y=3.9;
        Dreieck.a=6;
        Dreieck.b=7;
        Dreieck.c=4;
        Dreieck.sortiereSeiten();
        System.out.printf("a=%f, b=%f, c=%f\n",Dreieck.a,Dreieck.b,Dreieck.c);

        if (Dreieck.equals(x,y,15)) System.out.println("gleich");
        else System.out.println("ungleich");
    }
}
