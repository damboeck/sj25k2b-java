package animate;

/**
 * Immutable Klasse für Vektoren in der Ebene
 */
public class Vect2D {

    public final double x;
    public final double y;

    public static final Vect2D NULL = new Vect2D(0, 0);
    public static final Vect2D X    = new Vect2D(1, 0);
    public static final Vect2D Y    = new Vect2D(0, 1);

    public Vect2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double abs() {
        return Math.sqrt(x * x + y * y);
    }

    public Vect2D neg() {
        return new Vect2D(-x, -y);
    }

    public Vect2D mult(double d) {
        return new Vect2D(x * d, y * d);
    }

    public Vect2D normal() {
        return new Vect2D(-y,x);
    }

    public Vect2D eins() {
        return new Vect2D(x/abs(),y/abs());
    }

    public Vect2D add(Vect2D v) {
        return new Vect2D(x + v.x, y + v.y);
    }

    public Vect2D sub(Vect2D v) {
        return new Vect2D(x - v.x, y - v.y);
    }

    public double in(Vect2D v) {
        return x * v.x + y * v.y;
    }

}
