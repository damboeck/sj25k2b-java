package animate;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class SpringenderBall extends MyFrameAnimate {

    Ball b;

    public static void main(String[] args) {
        new SpringenderBall("Springender Ball", 800, 600);
    }

    public SpringenderBall(String title, int width, int height) {
        super(title, width, height);
        b = new Ball(Color.red, 20, 100,100,0.02,-0.02,0,0.001);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
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
