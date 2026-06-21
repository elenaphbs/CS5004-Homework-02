package student;

/**
 * This is a static class (essentially functions) that will help you
 * build objects from CSV strings. These objects are then used in the
 * rest of the program. Often these builders are associated with the
 * objects themselves and the concept of a factory, but we placed
 * them here to keep the code clean (and to help guide you).
 */
public final class Builder {
    /** Index for employee type in employee CSV. */
    private static final int EMPLOYEE_TYPE = 0;
    /** Index for name in employee CSV. */
    private static final int NAME = 1;
    /** Index for id in employee CSV. */
    private static final int ID = 2;
    /** Index for pay rate in employee CSV. */
    private static final int PAY_RATE_INDEX = 3;
    /** Index for pretax deductions in employee CSV. */
    private static final int PRETAX_INDEX = 4;
    /** Index for YTD earnings in employee CSV. */
    private static final int YTD_EARNINGS_INDEX = 5;
    /** Index for YTD taxes paid in employee CSV. */
    private static final int YTD_TAXES_INDEX = 6;

    /**
     * Private constructor to prevent instantiation.
     */
    private Builder() {
    }

    /**
     * Builds an employee object from a CSV string.
     *
     * You may end up checking the type of employee (hourly or salary)
     * by looking at the first element of the CSV string. Then building
     * an object specific to that type.
     *
     * @param csv the CSV string
     * @return the employee object
     */
    public static IEmployee buildEmployeeFromCSV(String csv) {
        String[] list = csv.split(",");
        IEmployee employee = null;

        String name = list[NAME];
        String id = list[ID];

        double payRate;
        try {
            payRate = Double.parseDouble(list[PAY_RATE_INDEX]);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }

        String employeeType = list[EMPLOYEE_TYPE];

        double ytdEarnings;
        try {
            ytdEarnings = Double.parseDouble(list[YTD_EARNINGS_INDEX]);
        } catch (NumberFormatException e) {
            System.out.println("The format of YTD Earnings is wrong. A double is required.");
            throw new RuntimeException(e);
        }

        double ytdTaxesPaid;
        try {
            ytdTaxesPaid = Double.parseDouble(list[YTD_TAXES_INDEX]);
        } catch (NumberFormatException e) {
            System.out.println("The format of YTD taxes paid is wrong. A double is required.");
            throw e;
        }

        double pretaxDeductions;
        try {
            pretaxDeductions = Double.parseDouble(list[PRETAX_INDEX]);
        } catch (NumberFormatException e) {
            System.out.println("The format of pretax deduction is wrong. A double is required.");
            throw e;
        }

        if (list[0].equals("SALARY")) {
            employee = new SalaryEmployee(name, id, payRate,
                    ytdEarnings, ytdTaxesPaid, pretaxDeductions);
        } else if (list[0].equals("HOURLY")) {
            employee = new HourlyEmployee(name, id, payRate,
                    ytdEarnings, ytdTaxesPaid, pretaxDeductions);
        }
        return employee;
    }

    /**
     * Converts a TimeCard from a CSV String.
     *
     * @param csv csv string
     * @return a TimeCard object
     */
    public static ITimeCard buildTimeCardFromCSV(String csv) {
        String[] list = csv.split(",");
        String employeeId = list[0];
        double hoursWorked;
        try {
            hoursWorked = Double.parseDouble(list[1]);
        } catch (NumberFormatException e) {
            System.out.println("The format of hours worked is wrong. A double is required.");
            throw e;
        }
        return new TimeCard(employeeId, hoursWorked);
    }
}
