package schleifen;

public class UebungX {

    public static void drawXbesser(int size) {
        for (int z=0;z<size;z++) {
            for (int s=0;s<size;s++) {
                //System.out.print((s==z || s==(size-1-z))?"X":" ");
                if (s==z || s==(size-1-z))
                    System.out.print("X");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void normal(int v, int z, char c) {
        for (int i=0;i<v;i++) System.out.print(" ");
        System.out.print(c);
        for (int i=0;i<z;i++) System.out.print(" ");
        System.out.println(c);
    }

    public static void drawX(int size) {
        for (int v=0;v<size/2;v++) {
            normal(v,size-2-2*v,'X');
        }
        if (size%2==1) {
            // Ungerade Anzahl
            System.out.println(" ".repeat(size/2)+"X");
        }
        for (int v=size/2-1;v>=0;v--) {
            normal(v,size-2-2*v,'X');
        }
    }

    public static void main(String[] args) {
        drawX(4);
        System.out.println("");
        drawX(5);
        System.out.println("");
        drawX(9);
    }
}
