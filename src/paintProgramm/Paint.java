package paintProgramm;

import graphisch.MyFrame;
import paintProgramm.elements.Line;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.Vector;

public class Paint extends MyFrame {

    private Symbolleiste symbolleiste;
    private Vector<Paintable> elements = new Vector<>();

    public Paint() {
        super("Paint",1200,900);
        symbolleiste = new Symbolleiste(this.getWidth(), this.getHeight(), POSITION.LEFT);
        elements.add(new Line(new Point(10,10), new Point(400,400),Color.red,4));
        setVisible(true);
    }

    public static void main(String[] args) {
        new Paint();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (Paintable paintable : elements) {
            paintable.paint(g2d);
        }
        symbolleiste.paint(g2d);
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
