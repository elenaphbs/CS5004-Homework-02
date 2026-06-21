import org.junit.jupiter.api.Test;
import student.Builder;
import student.IEmployee;
import student.ITimeCard;

import static org.junit.jupiter.api.Assertions.*;

public class BuilderTest {
    @Test
    void testBuildEmployeeFromCSV() {
        String csv1 = "HOURLY,Elena,12345,50.0,0.0,80000.0,8000.0";
        String csv2 = "SALARY,Brent,54321,240000.0,one_thousand,90000.0,nine_thousand";

        IEmployee elena = null;
        try {
            elena = Builder.buildEmployeeFromCSV(csv1);
        } catch (NumberFormatException e) {
            fail("Shouldn't throw NumberFormatException");
        }

        IEmployee brent;
        try {
            brent = Builder.buildEmployeeFromCSV(csv2);
            fail("Should throw NumberFormatException");
        } catch (NumberFormatException e) {
            //Caught expected exception, test passed
        }

        assertEquals(csv1, elena.toCSV());
    }


    @Test
    void testBuildTimeCardFromCSV() {
        String csv1 = "12345,40";
        String csv2 = "54321,sixty";
        ITimeCard timeCard1 = null;
        try {
            timeCard1 = Builder.buildTimeCardFromCSV(csv1);
        } catch (NumberFormatException e) {
            fail("Shouldn't throw NumberFormatException");
        }


        ITimeCard timeCard2 = null;
        try {
            timeCard2 = Builder.buildTimeCardFromCSV(csv2);
            fail("Should throw NumberFormatException");
        } catch (NumberFormatException e) {
            //Caught expected exception, test passed
        }

        assertEquals("12345", timeCard1.getEmployeeID());
        assertEquals(40, timeCard1.getHoursWorked());


    }
}
