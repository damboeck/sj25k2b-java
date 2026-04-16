package paintProgramm.elements;

import java.awt.*;

public class Rectangle extends ZPF{

    public Rectangle(Point p1, Color lineColor, Color fillColor, int thickness) {
        super(p1, lineColor, fillColor, thickness);
    }
    public Rectangle(Point p1, Point p2, Color lineColor, Color fillColor, int thickness) {
        super(p1, p2, lineColor, fillColor, thickness);
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(fillColor);
        g.fillRect(p1.x, p1.y, p2.x-p1.x, p2.y-p1.y);
        g.setColor(lineColor);
        g.setStroke(new BasicStroke(thickness));
        g.drawRect(p1.x, p1.y, p2.x-p1.x, p2.y-p1.y);
    }

}