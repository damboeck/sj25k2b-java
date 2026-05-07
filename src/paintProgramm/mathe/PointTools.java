package paintProgramm.mathe;

import java.awt.*;

public class PointTools {

    /**
     * Berechnet den Abstand zwischen zwei Punkten
     * @param p1 Punkt 1
     * @param p2 Punkt 2
     * @return   Abstand zwischen Punkt 1 und Punkt 2
     */
    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.x-p1.x,2)+Math.pow(p2.y-p1.y,2));
    }

    /**
     * Berechnet den Abstand zwischen einem Punkt und einer Linie
     * @param p    Punkt
     * @param p1   erster Punkt der Linie
     * @param p2   zweiter Punkt der Linie
     * @return     Normalabstand zwischen Punkt und Linie
     */
    public static double normDistancePointLine(Point p, Point p1, Point p2) {
        return Math.abs((p2.x-p1.x)*(p1.y-p.y)-(p1.x-p.x)*(p2.y-p1.y))/distance(p1,p2);
    }
}
