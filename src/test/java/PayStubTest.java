import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import student.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PayStubTest {
    private IEmployee hourly;
    private IEmployee salary;
    private IPayStub payStub1;
    private IPayStub payStub2;

    @BeforeEach
    void setup() {
        hourly = new HourlyEmployee("Kiki", "00000", 30, 10000, 1000, 0);
        salary = new SalaryEmployee("Kimi", "11111", 240000, 20000, 4000, 1000);
        payStub1 = new PayStub(hourly, 1000, 200);
        payStub2 = new PayStub(salary, 10000, 2000);
    }

    @Test
    void testGetPay() {
        assertEquals(1000, payStub1.getPay());
        assertEquals(10000, payStub2.getPay());
    }

    @Test
    void  testGetTaxesPaid() {
        assertEquals(200, payStub1.getTaxesPaid());
        assertEquals(2000, payStub2.getTaxesPaid());
    }

    @Test
    void testToCSV() {
        assertEquals("Kiki,1000.0,200.0,10000.0,1000.0", payStub1.toCSV());
        assertEquals("Kimi,10000.0,2000.0,20000.0,4000.0", payStub2.toCSV());
    }
}
