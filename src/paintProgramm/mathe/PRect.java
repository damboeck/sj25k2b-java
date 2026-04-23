package paintProgramm.mathe;

import java.awt.*;

/**
 * 2D-Rechteck in der 2D-Ebene
 * x1,y1: untere(AWT obere) linke Ecke
 * x2,y2: obere(AWT untere) rechte Ecke
 * Immutable
 */
public class PRect {

    public final int x1,x2,y1,y2,w,h;
    public PRect(int x1,int y1,int x2,int y2) {
        this.x1=Integer.min(x1,x2);
        this.x2=Integer.max(x1,x2);
        this.y1=Integer.min(y1,y2);
        this.y2=Integer.max(y1,y2);
        this.w = this.x2-this.x1;
        this.h = this.y2-this.y1;
    }
    public PRect(Point p1, Point p2) {
        this(p1.x,p1.y,p2.x,p2.y);
    }

}
