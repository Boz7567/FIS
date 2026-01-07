package atm;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestAccount {
    Account a1;
    Account a2;

    @BeforeEach
    void setUp(){
        a1 = new Account(11111, 22222, 200, 400);
        a2 = new Account(22222, 11111, 500, 600);
    }

    @Test
    void testValidatePIN(){
        setUp();
        assertTrue(a1.validatePIN(22222));
        assertTrue(a2.validatePIN(11111));
        assertTrue(!a1.validatePIN(12345));
    }

    @Test
    void testGetAvailableBalance(){
        setUp();
        assertTrue(new Euro(200).equalTo(a1.getAvailableBalance()));
        assertTrue(new Euro(500).equalTo(a2.getAvailableBalance()));
        assertTrue(!new Euro(500).equalTo(a1.getAvailableBalance()));
    }

    @Test
    void testGetTotalBalance(){
        setUp();
        assertTrue(new Euro(400).equalTo(a1.getTotalBalance()));
        assertTrue(new Euro(600).equalTo(a2.getTotalBalance()));
        assertTrue(!new Euro(600).equalTo(a1.getTotalBalance()));
    }

    @Test
    void testCredit(){
        setUp();
        a1.credit(new Euro(100));
        assertTrue(a1.getTotalBalance().equalTo(new Euro(500)));

        a2.credit(new Euro(200));
        assertTrue(a2.getTotalBalance().equalTo(new Euro(800)));

        a2.credit(new Euro(0));
        assertTrue(a2.getTotalBalance().equalTo(new Euro(800)));
    }

    @Test
    void testDebit(){
        setUp();
        a1.debit(new Euro(200));
        assertTrue(a1.getAvailableBalance().equalTo(new Euro(0)));
        assertTrue(a1.getTotalBalance().equalTo(new Euro(200)));
        
        a2.debit(new Euro(100));
        assertTrue(a2.getAvailableBalance().equalTo(new Euro (400)));
        assertTrue(a2.getTotalBalance().equalTo(new Euro (500)));


        a1.debit(new Euro(-100));
        assertTrue(a1.getAvailableBalance().equalTo(new Euro(100))); //Don't know if this is correct behavior
        assertTrue(a1.getTotalBalance().equalTo(new Euro(300)));
    }

    @Test
    void testGetAccountNumber(){
        setUp();
        assertEquals(11111, a1.getAccountNumber());
        assertEquals(22222, a2.getAccountNumber());
    }
}
