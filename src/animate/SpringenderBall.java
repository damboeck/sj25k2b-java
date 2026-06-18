package animate;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.Vector;

public class SpringenderBall extends MyFrameAnimate {

    Ball b;
    Vector<Fixable> fixables = new Vector<>();

    public static void main(String[] args) {
        new SpringenderBall("Springender Ball", 800, 600);
    }

    public SpringenderBall(String title, int width, int height) {
        super(title, width, height);
        b = new Ball(Color.red, 20, 100,300,0.1,-0.1,0,0.00005);
        fixables.add(new FixHLine(20));
        fixables.add(new FixHLine(height-5));
        fixables.add(new FixVLine(5));
        fixables.add(new FixVLine(width-5));
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        b.move(this.getDeltaTimeMs());
        for (Fixable f : fixables) {
            b.collision(f);
        }
        // Kollisionen
        b.paint(g2);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }
}
