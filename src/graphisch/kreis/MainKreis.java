package graphisch.kreis;

import graphisch.MyFrame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.Vector;

public class MainKreis extends MyFrame {

    private EDITMODE editmode = EDITMODE.NORMAL;
    private Point    lastMC; // Letzte Mausposition (Mouse-Cursor)
    private Vector<Kreis> kreise;
    private Kreis         selectedKreis;

    public MainKreis() {
        super("Kreis", 1000, 800);
        Kreis k = new Kreis(100,500,400,Color.red,Color.magenta,5);
        kreise = new Vector<>();
        kreise.add(k);
        kreise.add(new Kreis(60,300,120,Color.blue,null,15));
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainKreis();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for(Kreis k : kreise)
            k.paint(g2);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (e.getButton()) {
            case MouseEvent.BUTTON1: // Linke Maustaste
                selectedKreis=null;
                Point mc = e.getPoint();
                for (Kreis k : kreise) {
                    if (k.onElement(mc)) {
                        selectedKreis = k;
                        lastMC = mc;
                        if ((e.getModifiersEx() & MouseEvent.SHIFT_DOWN_MASK) != 0) {
                            editmode = EDITMODE.RESIZE;
                        } else {
                            editmode = EDITMODE.MOVE;
                        }
                    }
                }
                if (selectedKreis == null) {
                    Kreis k = new Kreis(0,mc.getX(),mc.getY(),Color.blue,null,5);
                    kreise.add(k);
                    selectedKreis = k;
                    editmode = EDITMODE.RESIZE;
                    lastMC = mc;
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
                case MOVE, RESIZE -> editmode = EDITMODE.NORMAL;
                }
                break;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point mc = e.getPoint();
        switch (editmode) {
            case MOVE:
                selectedKreis.move(mc.x-lastMC.x,mc.y-lastMC.y);
                lastMC = mc;
                repaint();
                break;
            case RESIZE:
                selectedKreis.setRadiusFromPoint(mc);
                lastMC = mc;
                repaint();
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
