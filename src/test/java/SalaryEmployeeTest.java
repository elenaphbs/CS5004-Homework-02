import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import student.Employee;
import student.HourlyEmployee;
import student.IPayStub;
import student.SalaryEmployee;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalaryEmployeeTest {

    private Employee brent;

    @BeforeEach
    void setup() {
        brent = new SalaryEmployee("Brent", "54321", 240000, "SALARY", 90000, 9000, 1000);
    }

    @Test
    void testGetName() {
        assertEquals("Brent", brent.getName());
    }

    @Test
    void testGetID() {
        assertEquals("54321", brent.getID());
    }

    @Test
    void testGetPayRate(){
        assertEquals(240000, brent.getPayRate());
    }

    @Test
    void testGetEmployeeType() {
        assertEquals("SALARY", brent.getEmployeeType());
    }

    @Test
    void testGetYTDEarnings() {
        assertEquals(90000, brent.getYTDEarnings());
    }

    @Test
    void testGetYTDTaxesPaid() {
        assertEquals(9000, brent.getYTDTaxesPaid());
    }

    @Test
    void testGetPretaxDeductions() {
        assertEquals(1000, brent.getPretaxDeductions());
    }

    @Test
    void testRunPayroll() {
        IPayStub payStub1 = brent.runPayroll(40);
        assertEquals("Brent,6961.5,2038.5,96961.5,11038.5",payStub1.toCSV());

        IPayStub payStub2 = brent.runPayroll(60);
        assertEquals("Brent,6961.5,2038.5,103923.0,13077.0",payStub2.toCSV());
    }

    @Test
    void testToCSV() {
        assertEquals("SALARY,Brent,54321,240000.0,1000.0,90000.0,9000.0", brent.toCSV());
    }

    @Test
    void testCalculateGrossPay() {
        assertEquals(10000, brent.calculateGrossPay(40));//
        assertEquals(10000, brent.calculateGrossPay(60));//
    }
}
