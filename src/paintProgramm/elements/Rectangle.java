package paintProgramm.elements;

import org.w3c.dom.css.Rect;
import paintProgramm.mathe.PRect;

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
        PRect r = new PRect(p1,p2);
        g.setColor(fillColor);
        if (selected) g.setColor(Color.gray); // Auswahlfarbe
        g.fillRect(r.x1, r.y1, r.w, r.h);
        g.setColor(lineColor);
        g.setStroke(new BasicStroke(thickness));
        g.drawRect(r.x1, r.y1, r.w, r.h);
    }

    @Override
    public boolean select(Point mc) {
        PRect r = new PRect(p1,p2);
        return (r.x1<=mc.x && r.x2>=mc.x && r.y1<=mc.y && r.y2>=mc.y);
    }

}