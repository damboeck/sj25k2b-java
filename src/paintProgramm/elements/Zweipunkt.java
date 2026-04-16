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

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }
}
