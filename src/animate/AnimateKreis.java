package animate;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class AnimateKreis extends MyFrameAnimate{

    double mx=50,my=300,r=40;
    double v = 20./50.;

    public static void main(String[] args) {
        new AnimateKreis("Animate Kreis", 800, 600);
    }

    public AnimateKreis(String title, int width, int height) {
        super(title, width, height);
        this.setFrameTimeMs(5);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        mx += v*this.getDeltaTimeMs();
        g.setColor(Color.RED);
        g.fillOval((int)(mx-r), (int)(my-r), (int)(2*r), (int)(2*r));
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
