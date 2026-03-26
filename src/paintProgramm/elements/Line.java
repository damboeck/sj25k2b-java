package paintProgramm.elements;

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
        g.setStroke(new BasicStroke(thickness));
        g.drawLine(p1.x, p1.y, p2.x, p2.y);
    }

}
