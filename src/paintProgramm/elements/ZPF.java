package paintProgramm.elements;

import java.awt.*;

public abstract class ZPF extends Zweipunkt{

    protected Color fillColor;

    public ZPF(Point p1, Color lineColor, Color fillColor, int thickness) {
        super(p1, p1, lineColor, thickness);
        this.fillColor = fillColor;
    }

    public ZPF(Point p1, Point p2, Color lineColor, Color fillColor, int thickness) {
        super(p1, p2, lineColor, thickness);
        this.fillColor = fillColor;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

}
