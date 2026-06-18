package animate;

import paintProgramm.Paintable;

import java.awt.*;

public class Ball implements Paintable, Animateable {

    private Color c;
    private double r;
    private Vect2D pos,posOld;
    private Vect2D v,vOld;
    private Vect2D a,aOld;

    public Ball(Color c, double r, Vect2D pos, Vect2D v, Vect2D a) {
        this.c = c;
        this.r = r;
        this.pos = pos;
        this.v = v;
        this.a = a;
        calcOld();
    }
    public Ball(Color c, double r, double x, double y, double vx, double vy, double ax, double ay) {
        this(c,r,new Vect2D(x,y),new Vect2D(vx,vy),new Vect2D(ax,ay));
    }

    private void calcOld() {
        posOld = pos;
        vOld = v;
        aOld = a;
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(c);
        g.fillOval((int)(pos.x-r),(int)(pos.y-r),(int)(2*r),(int)(2*r));
    }

    @Override
    public void move(double deltaTimeMs) {
        calcOld();
        v   = vOld.add(aOld.mult(deltaTimeMs));
        pos = posOld.add(vOld.mult(deltaTimeMs));
        // Beschleunigung bleibt gleich
        a=aOld;
    }

    @Override
    public void collision(Fixable a) {
        if (a instanceof FixVLine) {
            FixVLine e = (FixVLine) a;
            // Kollision mit vertikaler Linie


        } else if (a instanceof FixHLine) {
            FixHLine e = (FixHLine) a;
            // Kollision mit horizontaler Linie
            if (posOld.y<=e.y && pos.y>(e.y-r)) {
                // Reflexion nach oben
                v = new Vect2D(v.x,-v.y);
                //pos = new Vect2D(pos.x,???);
            }
        } else throw new RuntimeException("Unbekannte Fixable: " + a.getClass().getName());
    }

}
