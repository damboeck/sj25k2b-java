package graphisch;

import java.awt.*;

public class Linie3 extends Linie {

    public static void main(String[] args) {
        new Linie3();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.drawLine(10, 10, 200, 200);
    }

}
