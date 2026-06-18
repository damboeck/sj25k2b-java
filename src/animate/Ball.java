package animate;

import paintProgramm.Paintable;

import java.awt.*;

public class Ball implements Paintable, Animateable {

    private static final double GUMMI_REFLEX = 0.6;
    private static final double GUMMI_BEW    = 0.99;
    private static final double REIBUNG      = 0.998;
    private static final double HAFTGRENZE   = 0.02;

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
        v   = vOld.add(aOld.mult(deltaTimeMs)).mult(REIBUNG);
        pos = posOld.add(vOld.mult(deltaTimeMs));
        // Beschleunigung bleibt gleich
        a=aOld;
        // Haftgrenze
        if (v.abs()<HAFTGRENZE) v = Vect2D.NULL;
    }

    @Override
    public void collision(Fixable a) {
        if (a instanceof FixVLine) {
            FixVLine e = (FixVLine) a;
            // Kollision mit vertikaler Linie
            if (posOld.x<=e.x && pos.x>(e.x-r)) {
                // Reflexion nach links
                v = new Vect2D(-v.x*GUMMI_REFLEX,v.y*GUMMI_BEW);
                pos = new Vect2D(-2*r+2*e.x-pos.x,pos.y);
            } else if (posOld.x>=e.x && pos.x<(e.x+r)) {
                // Reflexion nach rechts
                v = new Vect2D(-v.x*GUMMI_REFLEX,v.y*GUMMI_BEW);
                pos = new Vect2D(+2*r+2*e.x-pos.x,pos.y);
            }

        } else if (a instanceof FixHLine) {
            FixHLine e = (FixHLine) a;
            // Kollision mit horizontaler Linie
            if (posOld.y<=e.y && pos.y>(e.y-r)) {
                // Reflexion nach oben
                v = new Vect2D(v.x*GUMMI_BEW,-vOld.y*GUMMI_REFLEX);
                pos = new Vect2D(pos.x,-2*r+2*e.y-pos.y);
            } else if (posOld.y>=e.y && pos.y<(e.y+r)) {
                // Reflexion nach unten
                v = new Vect2D(v.x*GUMMI_BEW,-v.y*GUMMI_REFLEX);
                pos = new Vect2D(pos.x,+2*r+2*e.y-pos.y);
            }
        } else throw new RuntimeException("Unbekannte Fixable: " + a.getClass().getName());
    }

    /**
     * Kollision mit anderem Ball
     * @param b anderer Ball
     */
    public void collision(Ball b) {

    }

}
