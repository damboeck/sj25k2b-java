package graphisch.kreis;

import graphisch.MyFrame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class MainKreis extends MyFrame {

    private EDITMODE editmode = EDITMODE.NORMAL;
    private Point    lastMC; // Letzte Mausposition (Mouse-Cursor)
    private Kreis k;

    public MainKreis() {
        super("Kreis", 1000, 800);
        k = new Kreis(100,500,400,Color.red,Color.magenta,5);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainKreis();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        k.paint(g2);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (e.getButton()) {
            case MouseEvent.BUTTON1: // Linke Maustaste
                Point mc = e.getPoint();
                if (k.onElement(mc)){
                    lastMC = mc;
                    if ((e.getModifiersEx()&MouseEvent.SHIFT_DOWN_MASK)!=0) {
                        editmode = EDITMODE.RESIZE;
                    } else {
                        editmode = EDITMODE.MOVE;
                    }
                }
                break;
            case MouseEvent.BUTTON2: // Mittlere Maustaste

                break;
            case MouseEvent.BUTTON3: //  Rechte Maustaste

                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch(e.getButton()) {
            case MouseEvent.BUTTON1: // Linke Maustaste
                Point mc = e.getPoint();
                switch (editmode) {
                case MOVE:
                    // Verschiebung beenden
                    k.move(mc.x-lastMC.x,mc.y-lastMC.y);
                    repaint();
                    break;
                case RESIZE:
                    // Größenänderung beenden
                    k.setRadiusFromPoint(mc);
                    repaint();
                    break;
                }
                break;
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }
}
