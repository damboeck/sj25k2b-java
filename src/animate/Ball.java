package animate;

import paintProgramm.Paintable;

import java.awt.*;

public class Ball implements Paintable {

    private Color c;
    private double r;
    private Vect2D pos;
    private Vect2D v;
    private Vect2D a;

    public Ball(Color c, double r, Vect2D pos, Vect2D v, Vect2D a) {
        this.c = c;
        this.r = r;
        this.pos = pos;
        this.v = v;
        this.a = a;
    }
    public Ball(Color c, double r, double x, double y, double vx, double vy, double ax, double ay) {
        this(c,r,new Vect2D(x,y),new Vect2D(vx,vy),new Vect2D(ax,ay));
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(c);
        g.fillOval((int)(pos.x-r),(int)(pos.y-r),(int)(2*r),(int)(2*r));
    }

}
