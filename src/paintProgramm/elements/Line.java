package paintProgramm.elements;

import paintProgramm.mathe.PointTools;

import java.awt.*;

public class Line extends Zweipunkt{

    public Line(Point p1, Color lineColor, int thickness) {
        super(p1, p1, lineColor, thickness);
    }
    public Line(Point p1, Point p2, Color lineColor, int thickness) {
        super(p1, p2, lineColor, thickness);
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(lineColor);
        if (selected) g.setColor(Color.gray); // Auswahlfarbe
        g.setStroke(new BasicStroke(thickness));
        g.drawLine(p1.x, p1.y, p2.x, p2.y);
    }

    @Override
    public boolean select(Point mc) {
        double l = PointTools.distance(p1,p2);
        double a = PointTools.distance(p1,mc);
        double b = PointTools.distance(p2,mc);
        double n = PointTools.normDistancePointLine(mc,p1,p2);
        double delta = 5;
        return ((a+b)<(l+delta) && (n<delta));
    }
}
