import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import student.ITimeCard;
import student.TimeCard;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeCardTest {
    private ITimeCard timeCard1;
    private ITimeCard timeCard2;

    @BeforeEach
    void setup() {
        timeCard1 = new TimeCard("12345", 40);
        timeCard2 = new TimeCard("54321", 60);
    }

    @Test
    void testGetEmployeeID() {
        assertEquals("12345", timeCard1.getEmployeeID());
        assertEquals("54321", timeCard2.getEmployeeID());
    }

    @Test
    void testGetHoursWorked() {
        assertEquals(40, timeCard1.getHoursWorked());
        assertEquals(60, timeCard2.getHoursWorked());
    }
}

