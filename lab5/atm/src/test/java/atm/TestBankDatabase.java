package atm;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestBankDatabase {
    BankDatabase b;

    @BeforeEach
    void setUp(){
        b = new BankDatabase();
    }
    
    @Test
    void testAuthenticateUser(){
        setUp();
        assertTrue(b.authenticateUser(12345, 54321));
        assertTrue(b.authenticateUser(98765, 56789));
        assertTrue(!b.authenticateUser(0, 0));
        assertTrue(!b.authenticateUser(12345, 56789));
    }

    @Test
    void testGetAvailableBalance(){
        setUp();
        assertTrue(b.getAvailableBalance(12345).equalTo(new Euro(1000)));
        assertTrue(b.getAvailableBalance(98765).equalTo(new Euro(200)));
    }

    @Test
    void testGetTotalBalance(){
        setUp();
        assertTrue(b.getTotalBalance(12345).equalTo(new Euro(1200)));
        assertTrue(b.getTotalBalance(98765).equalTo(new Euro(200)));
    }

    @Test
    void testCredit(){
        setUp();
        b.credit(12345, new Euro(100));
        b.credit(98765, new Euro(100));
        assertTrue(b.getTotalBalance(12345).equalTo(new Euro(1300)));
        assertTrue(b.getTotalBalance(98765).equalTo(new Euro(300)));
    }

    @Test
    void testDebit(){
        setUp();
        b.debit(12345, new Euro(100));
        b.debit(98765, new Euro(100));
        assertTrue(b.getTotalBalance(12345).equalTo(new Euro(1100)));
        assertTrue(b.getAvailableBalance(12345).equalTo(new Euro(900)));
        assertTrue(b.getTotalBalance(98765).equalTo(new Euro(100)));
        assertTrue(b.getAvailableBalance(98765).equalTo(new Euro(100)));
    }
}
