package paintProgramm;

import graphisch.MyFrame;
import paintProgramm.elements.Line;
import paintProgramm.tools.Toolbar;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.Vector;

public class Paint extends MyFrame implements WindowInfo {

    private final int FRAME_TOP    = 30;
    private final int FRAME_LEFT   = 8;
    private final int FRAME_BOTTOM = 8;
    private final int FRAME_RIGHT  = 8;

    private Toolbar toolbar;
    private Vector<Paintable> elements = new Vector<>();

    public Paint() {
        super("Paint",1200,900);
        toolbar = new Toolbar(POSITION.LEFT,this);
        elements.add(new Line(new Point(10,10), new Point(400,400),Color.red,4));
        setVisible(true);
    }

    public static void main(String[] args) {
        new Paint();
    }

    public int getWidth() {
        return super.getWidth()-FRAME_LEFT-FRAME_RIGHT;
    }
    public int getHeight() {
        return super.getHeight()-FRAME_BOTTOM-FRAME_TOP;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(FRAME_LEFT,FRAME_TOP);

        for (Paintable paintable : elements) {
            paintable.paint(g2d);
        }
        toolbar.paint(g2d);
    }

    private Point transformMouseCursor(Point mouseCursor) {
        return new Point(mouseCursor.x-FRAME_LEFT,mouseCursor.y-FRAME_TOP);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (toolbar.leftMousePressed(transformMouseCursor(e.getPoint()))) {
                repaint();
                return;
            }
        }
        // Klicks in die Zeichenfläche verarbeiten
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }
}
