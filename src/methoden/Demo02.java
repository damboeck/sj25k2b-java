package methoden;

public class Demo02 {

    public static void main(String[] args) {
        double x=3.19;
        double y=3.191;
        if (Dreieck.equals(x,y,0.01)) System.out.println("gleich");
        else System.out.println("ungleich");
    }
}
