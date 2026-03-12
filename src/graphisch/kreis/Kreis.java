package graphisch.kreis;

import java.awt.*;

/**
 * Klasse für einen Kreis welcher in einem Fenster gezeichnet werden kann.
 * Es soll die Möglichkeit geben, den Kreis zu verschieben,
 * zu vergrößern, zu verkleinern und weiteres.
 * @author damboeck (2BHET)
 */
public class Kreis {

    /** Radius des Kreises */
    private double r;
    /** Mittelpunkt des Kreises */
    private double mx, my;
    /** Rand-Farbe des Kreises */
    private Color lineColor;
    /** Füll-Farbe des Kreises */
    private Color fillColor;
    /** Dicke der Linie */
    private int lineWidth;

    public Kreis(double r, double mx, double my, Color lineColor, Color fillColor, int lineWidth) {
        this.r = r;
        this.mx = mx;
        this.my = my;
        this.lineColor = lineColor;
        this.fillColor = fillColor;
        this.lineWidth = lineWidth;
    }

    public Kreis(double r, double mx, double my, Color lineColor) {
        this(r,mx,my,lineColor,null,1);
    }

    public void paint(Graphics2D g) {
        if (fillColor != null) {
            g.setColor(fillColor);
            g.fillOval((int)(mx-r),(int)(my-r),(int)(2*r),(int)(2*r));
        }
        if (lineColor != null) {
            g.setColor(lineColor);
            Stroke oldStroke = g.getStroke();
            g.setStroke(new BasicStroke(lineWidth));
            g.drawOval((int)(mx-r),(int)(my-r),(int)(2*r),(int)(2*r));
            g.setStroke(oldStroke);
        }
    }

    /**
     * Bestimmt ob der Punkt p auf dem Kreis liegt (am Kreisrand)
     * @param p Punkt, welcher geprüft werden soll
     * @return
     */
    public boolean onElement(Point p) {
        return Math.abs(distanceFromCenter(p)-r)<=Math.max(lineWidth/2.0,2)+2;
    }

    /**
     * Bestimmt ob der Punkt p im Kreis liegt (inklusive Kreisrand)
     * @param p Punkt, welcher geprüft werden soll
     * @return
     */
    public boolean inElement(Point p) {
        return distanceFromCenter(p)<=r+lineWidth/2.0;
    }

    private double distanceFromCenter(Point p) {
        return Math.sqrt((p.x-mx)*(p.x-mx)+(p.y-my)*(p.y-my));
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getMx() {
        return mx;
    }

    public void setMx(double mx) {
        this.mx = mx;
    }

    public double getMy() {
        return my;
    }

    public void setMy(double my) {
        this.my = my;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public int getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(int lineWidth) {
        this.lineWidth = lineWidth;
    }
}
