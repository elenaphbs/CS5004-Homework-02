package student;

/**
 * Represents a time card for an employee.
 */
public class TimeCard implements ITimeCard {

    /** The employee ID. */
    private String id;
    /** The hours worked. */
    private double hoursWorked;

    /**
     * Constructor for TimeCard.
     *
     * @param id the employee ID
     * @param hoursWorked the hours worked
     */
    public TimeCard(String id, double hoursWorked) {
        this.id = id;
        this.hoursWorked = hoursWorked;
    }

    /**
     * Gets the employee ID.
     *
     * @return the employee ID
     */
    public String getEmployeeID() {
        return this.id;
    }

    /**
     * Gets the hours worked.
     *
     * @return the hours worked
     */
    public double getHoursWorked() {
        return this.hoursWorked;
    }
}
