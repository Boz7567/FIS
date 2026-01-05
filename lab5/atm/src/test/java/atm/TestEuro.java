package atm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestEuro {

    private Euro euro1;
    private Euro euro2;

    @BeforeEach
    public void setUp() {
        euro1 = new Euro(530.5);
        euro2 = new Euro(100);
    }

    @Test
    void testGetValue(){
        setUp();
        assertEquals(530.5, euro1.getValue());
        assertEquals(100, euro2.getValue());
    }

    @Test
    void testSum(){
        setUp();
        assertEquals(1061, euro1.sum(euro1).getValue());
        assertEquals(200, euro2.sum(euro2).getValue());
        assertEquals(1261, euro1.sum(euro2).getValue());
        assertEquals(1261, euro1.sum(new Euro(0)).getValue());
        assertEquals(1000, euro1.sum(new Euro(-261)).getValue());
        assertEquals(-1, euro1.sum(new Euro(-1001)).getValue());
        
        euro1 = new Euro(0.2);
        euro2 = new Euro(0.1);
        //this fails because of how decimals are represented  in the double type
        assertEquals(0.3, euro1.sum(euro2).getValue());
    }


    @Test
    void testSubtract(){
        setUp();
        assertEquals(0, euro1.subtract(euro1).getValue());
        assertEquals(0, euro2.subtract(euro2).getValue());
        setUp();
        assertEquals(430.5, euro1.subtract(euro2).getValue());
        assertEquals(-330.5, euro2.subtract(euro1).getValue());

        euro1 = new Euro(0.2);
        assertEquals(0, euro1.subtract(euro1).getValue());
        euro1 = new Euro(0.2);
        euro2 = new Euro(0.1);
        assertEquals(0.1, euro1.subtract(euro2).getValue());
        assertEquals(0, euro1.subtract(euro2).getValue());
    }

    @Test
    void testEqualTo(){
        setUp();
        assertTrue(euro1.equalTo(euro1));
        assertTrue(euro2.equalTo(euro2));
        assertTrue(euro2.sum(euro2).equalTo(new Euro(200)));
    }

    @Test
    void testLessThan(){
        setUp();
        assertTrue(euro2.lessThan(euro1));
        assertTrue(!euro1.lessThan(euro2));
    }
}
