package mathematik;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TesteMathe {

    public void assertZs(int expected, int input){
        assertEquals(expected, Ziffernsumme.zs(input));
    }

    @Test
    public void testeZiffernsumme1(){
        assertEquals(6,  Ziffernsumme.zs(123));
        assertEquals(15, Ziffernsumme.zs(12345));
    }

    @Test
    public void testeZiffernsumme2(){
        assertZs( 10,1234);
        assertZs( 16,22345);
        assertZs( 45,99999);
        assertZs(-16,-1456);
        assertZs( 41,3648956);
    }
}
