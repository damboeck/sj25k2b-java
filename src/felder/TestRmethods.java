package felder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestRmethods {

    @Test
    public void testKleinsterWiderstand() {
        assertEquals(2.0, Rmethods.kleinsterWiderstand(new double[]{2.0, 3.0, 6.0}),0.001);
        assertEquals(1.5, Rmethods.kleinsterWiderstand(new double[]{3.0, 1.5, 6.0}),0.001);
        assertEquals(-3.0, Rmethods.kleinsterWiderstand(new double[]{-3.0, 1.5, 6.0}),0.001);
    }

    @Test
    public void testSerienWiderstand() {
        assertEquals(11.0, Widerstand.gesamtWiderstandSerie(new double[]{2.0, 3.0, 6.0}),0.001);
        assertEquals(10.5, Widerstand.gesamtWiderstandSerie(new double[]{3.0, 1.5, 6.0}),0.001);
        assertEquals(4.5, Widerstand.gesamtWiderstandSerie(new double[]{-3.0, 1.5, 6.0}),0.001);
    }
}
