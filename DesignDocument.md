# Payroll Generator Design Document


This document is meant to provide a tool for you to demonstrate the design process. You need to work on this before you code, and after have a finished product. That way you can compare the changes, and changes in design are normal as you work through a project. It is contrary to popular belief, but we are not perfect our first attempt. We need to iterate on our designs to make them better. This document is a tool to help you do that.

If you are using mermaid markup to generate your class diagrams, you may edit this document in the sections below to insert your markup to generate each diagram. Otherwise, you may simply include the images for each diagram requested below in your zipped submission (be sure to name each diagram image clearly in this case!)

## (INITIAL DESIGN): Class Diagram

Include a UML class diagram of your initial design for this assignment. If you are using the mermaid markdown, you may include the code for it here. For a reminder on the mermaid syntax, you may go [here](https://mermaid.js.org/syntax/classDiagram.html)

```mermaid
---
title: Payroll Generator UML
---
classDiagram
    direction TB
    IEmployee <|.. Employee : implements
    Employee <|-- HourlyEmployee : extends
    Employee <|-- SalaryEmployee : extends
    ITimeCard <|..TimeCard : implements
    IPayStub <|..PayStub : implements

    PayStub --> Employee : references
    IEmployee ..> IPayStub : returns
    Builder ..> IEmployee : returns
    Builder ..> ITimeCard : returns
    
    PayrollGenerator ..* Arguments : contains (inner class)
%%    PayrollGenerator ..* IEmployee : creates
%%    PayrollGenerator ..* ITimeCard : creates
%%    PayrollGenerator ..* IPayStub : creates
%%    PayrollGenerator ..* Builder : uses
%%    PayrollGenerator ..* FileUtil : uses
    
    class IEmployee { 
        <<interface>>
        + getName() String
        + getID() String
        + getPayRate() double
        + getEmployType() String
        + getYTDEarnings() double
        + getYTDTaxesPaid() double
        + getPretaxDeductions() double
        + runPayroll(double hoursWorked) IPayStub
        + toCSV() String
    }
    
    class Employee {
        <<abstract>>
        - String name 
        - String ID
        - double payRate
        - String employType
        - double YTDEarnings
        - double YTDTaxesPaid
        - double pretaxDeductions
        %% Constructor: Employee(String name, String ID, double payRate,  String employType,
        %%                       double YTDEarnings, double YTDTaxesPaid, double pretaxDeductions)
        + Employee()
        + calculateGrossPay(double hoursWorked)* double 
    }
    
    class HourlyEmployee {
        + HourlyEmployee()
        + calculateGrossPay(double hoursWorked) double
    }

    class SalaryEmployee {
        + SalaryEmployee()
        + calculateGrossPay(double hoursWorked) double
    }
    
    class IPayStub {
        <<interface>>
        + getPay() double
        + getTaxesPaid() double
        + toCSV() String
    }

    class PayStub {
        - IEmployee employee
        - double netPay
        - double taxes
        + PayStub(IEmployee employee, double netPay, double taxes)
    }
 
    class ITimeCard {
        <<interface>>
        + getEmloyeeID() String
        + getHoursWorked() double
    }
    
    class TimeCard {
        - String ID
        - double hoursWorked
        + TimeCard(String ID, Double hoursWorked)
    }
    
    class Builder {
        - builder()
        + buildEmployeeFromCSV(String csv)$ IEmployee
        + buildTimeCardFromCSV(String csv)$ ITimeCard
    }
    
    class FileUtil {
        + String EMPLOYEE_HEADER
        + String PAY_STUB_HEADER
        - FileUtile()
        + readFileToList(String file) List<String>
        + writeFile(String outFile, List<String> lines)
        + writeFile(String outFile, List<String> lines, boolean backup)
    }
    
    class PayrollGenerator {
        - String DEFAULT_EMPLOYEE_FILE
        - String DEFAULT_PAYROLL_FILE
        - String DEFAULT_TIME_CARD_FILE
        - PayrollGenerator()
        + main(String[] args)
    }
    
    class Arguments {
        - String employeeFile
        - String payrollFile
        - String timeCards
        - Arguments()
        + getEmployeeFile() String
        + getPayrollFile() String
        + getTimeCards() String
        + printHelp() 
        + process(String[] args) Arguments
    }

```




## (INITIAL DESIGN): Tests to Write - Brainstorm

Write a test (in english) that you can picture for the class diagram you have created. This is the brainstorming stage in the TDD process. 

> [!TIP]
> As a reminder, this is the TDD process we are following:
> 1. Figure out a number of tests by brainstorming (this step)
> 2. Write **one** test
> 3. Write **just enough** code to make that test pass
> 4. Refactor/update  as you go along
> 5. Repeat steps 2-4 until you have all the tests passing/fully built program

You should feel free to number your brainstorm. 

1. Test that the `HourlyEmployee` class properly returns `name` from `getName()`
2. Test that the `HourlyEmployee` class properly returns `ID` from `getID()`
3. Test that the `HourlyEmployee` class properly returns `payRate` from `getPayRate()`
4. Test that the `HourlyEmployee` class properly returns `employeeType` from `getEmployeeType()`
5. Test that the `HourlyEmployee` class properly returns `YTDEarnings` from `getYTDEarnings()`
6. Test that the `HourlyEmployee` class properly returns `YTDTaxesPaid` from `getYTDTaxesPaid()`
7. Test that the `HourlyEmployee` class properly returns `pretaxDeductions` from `getPretaxDeductions()`
8. Test that the `HourlyEmployee` class properly returns `PayStub` from `runPayroll(double hoursWorked)`
9. Test that the `HourlyEmployee` class properly returns employee information from `toCSV()`
10. Test that the `HourlyEmployee` class properly returns gross pay from `calculateGrossPay(double hoursWorked)`
11. Test that the `SalaryEmployee` class properly returns `name` from `getName()`
12. Test that the `SalaryEmployee` class properly returns `ID` from `getID()`
13. Test that the `SalaryEmployee` class properly returns `payRate` from `getPayRate()`
14. Test that the `SalaryEmployee` class properly returns `employeeType` from `getEmployeeType()`
15. Test that the `SalaryEmployee` class properly returns `YTDEarnings` from `getYTDEarnings()`
16. Test that the `SalaryEmployee` class properly returns `YTDTaxesPaid` from `getYTDTaxesPaid()`
17. Test that the `SalaryEmployee` class properly returns `pretaxDeductions` from `getPretaxDeductions()`
18. Test that the `SalaryEmployee` class properly returns `PayStub` from `runPayroll(double hoursWorked)`
19. Test that the `SalaryEmployee` class properly returns employee information from `toCSV()`
20. Test that the `SalaryEmployee` class properly returns gross pay from `calculateGrossPay(double hoursWorked)`
21. Test that the `PayStub` class properly returns `netPay` from `getPay()`
22. Test that the `PayStub` class properly returns `taxes` from `getTaxesPaid()`
23. Test that the `PayStub` class properly returns pay stub information from `toCSV()`
24. Test that the `TimeCard` class properly returns `ID` from `getEmployID()`
25. Test that the `TimeCard` class properly returns `hoursWorked` from `getHoursWorked()`
26. Test that the `Builder` class properly returns `IEmployee` from `buildEmployeeFromCSV()`
27. Test that the `Builder` class properly returns `TimeCard` from `buildTimeCardFromCSV()`
28. Test that the `FileUtil` class properly returns a list of String from `readFileToList()`
29. Test that the `FileUtil` class properly creates a new file and makes a backup file from `writeFile(String OutFile, List lines)` or `writeFile(String OutFile, List lines, boolean backup)`


## (FINAL DESIGN): Class Diagram

Go through your completed code, and update your class diagram to reflect the final design. We want both the diagram for your initial and final design, so you may include another image or include the finalized mermaid markup below. It is normal that the two diagrams don't match! Rarely (though possible) is your initial design perfect. 

```mermaid
---
title: Payroll Generator UML
---
classDiagram
    direction TB
    IEmployee <|.. Employee : implements
    Employee <|-- HourlyEmployee : extends
    Employee <|-- SalaryEmployee : extends
    ITimeCard <|.. TimeCard : implements
    IPayStub <|.. PayStub : implements

    PayStub --> Employee : references
    IEmployee ..> IPayStub : returns
    Builder ..> IEmployee : returns
    Builder ..> ITimeCard : returns
    
    PayrollGenerator ..* Arguments : contains (inner class)
    
    class IEmployee { 
        <<interface>>
        + getName() String
        + getID() String
        + getPayRate() double
        + getEmployeeType() String
        + getYTDEarnings() double
        + getYTDTaxesPaid() double
        + getPretaxDeductions() double
        + runPayroll(double hoursWorked) IPayStub
        + toCSV() String
    }
    
    class Employee {
        <<abstract>>
        - String name 
        - String id
        - double payRate
        - String employeeType
        - double ytdEarnings
        - double ytdTaxesPaid
        - double pretaxDeductions
        - double TAX_RATE$
        + Employee()
        + calculateGrossPay(double hoursWorked)* double 
    }
    
    class HourlyEmployee {
        - int STANDARD_HOURS$
        - double OVERTIME_MULTIPLIER$
        + HourlyEmployee()
        + calculateGrossPay(double hoursWorked) double
    }

    class SalaryEmployee {
        - int PAY_PERIODS$
        + SalaryEmployee()
        + calculateGrossPay(double hoursWorked) double
    }
    
    class IPayStub {
        <<interface>>
        + getPay() double
        + getTaxesPaid() double
        + toCSV() String
    }

    class PayStub {
        - IEmployee employee
        - double netPay
        - double taxes
        + PayStub(IEmployee employee, double netPay, double taxes)
    }
 
    class ITimeCard {
        <<interface>>
        + getEmployeeID() String
        + getHoursWorked() double
    }
    
    class TimeCard {
        - String id
        - double hoursWorked
        + TimeCard(String id, double hoursWorked)
    }
    
    class Builder {
        - int EMPLOYEE_TYPE$
        - int NAME$
        - int ID$
        - int PAY_RATE_INDEX$
        - int PRETAX_INDEX$
        - int YTD_EARNINGS_INDEX$
        - int YTD_TAXES_INDEX$
        - Builder()
        + buildEmployeeFromCSV(String csv)$ IEmployee
        + buildTimeCardFromCSV(String csv)$ ITimeCard
    }
    
    class FileUtil {
        + String EMPLOYEE_HEADER
        + String PAY_STUB_HEADER
        - FileUtil()
        + readFileToList(String file) List~String~
        + writeFile(String outFile, List~String~ lines)
        + writeFile(String outFile, List~String~ lines, boolean backup)
    }
    
    class PayrollGenerator {
        - String DEFAULT_EMPLOYEE_FILE$
        - String DEFAULT_PAYROLL_FILE$
        - String DEFAULT_TIME_CARD_FILE$
        - PayrollGenerator()
        + main(String[] args)$
    }
    
    class Arguments {
        - String employeeFile
        - String payrollFile
        - String timeCards
        - Arguments()
        + getEmployeeFile() String
        + getPayrollFile() String
        + getTimeCards() String
        + printHelp() 
        + process(String[] args) Arguments
    }

```


> [!WARNING]
> If you resubmit your assignment for manual grading, this is a section that often needs updating. You should double check with every resubmit to make sure it is up to date.





## (FINAL DESIGN): Reflection/Retrospective

> [!IMPORTANT]
> The value of reflective writing has been highly researched and documented within computer science, from learning new information to showing higher salaries in the workplace. For this next part, we encourage you to take time, and truly focus on your retrospective.

Take time to reflect on how your design has changed. Write in *prose* (i.e. do not bullet point your answers - it matters in how our brain processes the information). Make sure to include what were some major changes, and why you made them. What did you learn from this process? What would you do differently next time? What was the most challenging part of this process? For most students, it will be a paragraph or two. 
> Since I spent 4 hours thoroughly going through all the files and carefully designing all the classes, the final version of my design is almost the same as the original one. However, after completing the implementation, I ran CheckStyle to ensure code quality and made several refinements. I renamed fields like `ID`, `YTDEarnings`, and `YTDTaxesPaid` to `id`, `ytdEarnings`, and `ytdTaxesPaid` across Employee, Builder, and TimeCard to follow Java's camelCase naming convention. I also extracted magic numbers into named constants: `TAX_RATE`, `STANDARD_HOURS` and `OVERTIME_MULTIPLIER` in HourlyEmployee, `PAY_PERIODS` in SalaryEmployee, and CSV column index constants in Builder. These changes improved readability and made the code easier to maintain without changing any functionality.