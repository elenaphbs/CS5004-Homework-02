import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import student.Employee;
import student.HourlyEmployee;
import student.IPayStub;


import static org.junit.jupiter.api.Assertions.assertEquals;

class HourlyEmployeeTest {
    private Employee elena;

    @BeforeEach
    void setup() {
        elena = new HourlyEmployee("Elena", "12345", 50, "HOURLY", 80000, 8000, 0);
    }

    @Test
    void testGetName() {
        assertEquals("Elena", elena.getName());
    }

    @Test
    void testGetID() {
        assertEquals("12345", elena.getID());
    }

    @Test
    void testGetPayRate(){
        assertEquals(50, elena.getPayRate());
    }

    @Test
    void testGetEmployeeType() {
        assertEquals("HOURLY", elena.getEmployeeType());
    }

    @Test
    void testGetYTDEarnings() {
        assertEquals(80000, elena.getYTDEarnings());
    }

    @Test
    void testGetYTDTaxesPaid() {
        assertEquals(8000, elena.getYTDTaxesPaid());
    }

    @Test
    void testGetPretaxDeductions() {
        assertEquals(0, elena.getPretaxDeductions());
    }

    @Test
    void testRunPayroll() {
        IPayStub payStub1 = elena.runPayroll(40);
        assertEquals("Elena,1547.0,453.0,81547.0,8453.0",payStub1.toCSV());

        IPayStub payStub2 = elena.runPayroll(60);
        assertEquals("Elena,2707.25,792.75,84254.25,9245.75",payStub2.toCSV());
    }

    @Test
    void testToCSV() {
        assertEquals("HOURLY,Elena,12345,50.0,0.0,80000.0,8000.0", elena.toCSV());
    }

    @Test
    void testCalculateGrossPay() {
        assertEquals(2000, elena.calculateGrossPay(40));//
        assertEquals(3500, elena.calculateGrossPay(60));//
    }
}
