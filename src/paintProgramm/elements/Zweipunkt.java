package paintProgramm.elements;

import paintProgramm.Paintable;

import java.awt.*;

public abstract class Zweipunkt implements Paintable {

    protected Color lineColor;
    protected int   thickness;
    protected Point p1,p2;

    public Zweipunkt(Point p1, Point p2, Color lineColor, int thickness) {
        this.p1  = p1;
        this.p2  = p2;
        this.lineColor = lineColor;
        this.thickness = thickness;
    }

}
