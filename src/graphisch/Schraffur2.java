package graphisch;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public final class Schraffur2 extends MyFrame{

    private int n=10;

    public Schraffur2() {
        super("Schraffur2",1200,800);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Schraffur2();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        double d = this.getWidth() / (n+1d);
        for (double x=d; x<this.getWidth(); x+=d) {
            g.drawLine((int)x, 0, (int)x, this.getHeight());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        n -= e.getWheelRotation();
        if (n<1) n=1;
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }
}
