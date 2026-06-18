package animate;

import paintProgramm.Paintable;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.Vector;

public class SpringenderBall extends MyFrameAnimate {

    Vector<Animateable> animateables = new Vector<>();
    Vector<Fixable> fixables = new Vector<>();

    private final static double GRAVITY = 0;//0.00005;

    public static void main(String[] args) {
        new SpringenderBall("Springender Ball", 800, 600);
    }

    public SpringenderBall(String title, int width, int height) {
        super(title, width, height);
        animateables.add(new Ball(Color.red, 20, 100,300,0.1,-0.3,0,GRAVITY));
        animateables.add(new Ball(Color.blue, 20, 400,400,-0.1,-0.13,0,GRAVITY));
        fixables.add(new FixHLine(20));
        fixables.add(new FixHLine(height-5));
        fixables.add(new FixVLine(5));
        fixables.add(new FixVLine(width-5));
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for (Animateable a : animateables)
            a.move(this.getDeltaTimeMs());
        for (Animateable a : animateables)
            for (Fixable f : fixables) {
                a.collision(f);
            }
        CollisionService.collision(animateables);
        for (Fixable f : fixables)
            if (f instanceof Paintable)
                ((Paintable) f).paint(g2);
        for (Animateable a : animateables)
            if (a instanceof Paintable)
                ((Paintable) a).paint(g2);
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
