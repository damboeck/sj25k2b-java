package graphisch;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public final class Schraffur extends MyFrame {

    private int d=40;

    public Schraffur()  {
        super("Schraffur", 1200, 800);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Schraffur();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        if (d<1) throw new RuntimeException("Abstand muss positiv sein");
        for (int x=-getHeight();x<getWidth();x+=d) {
            g.drawLine(x, 0, x+getHeight(), getHeight());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        d -= e.getWheelRotation()*5;
        if (d<1) d=1;
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_UP,
                 KeyEvent.VK_PLUS,
                 KeyEvent.VK_ADD:
                d+=10;
                break;
            case KeyEvent.VK_DOWN,
                 KeyEvent.VK_MINUS,
                 KeyEvent.VK_SUBTRACT:
                d-=10;
                if (d<1) d=1;
                break;
            default: return;
        }
        repaint();
    }

}
