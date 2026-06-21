# Report for Payroll Generator

This report helps you demonstrate your understanding of the concepts. You should write this report after you have completed the project. 

## Technical Questions

1. What does CSV stand for? 

> CSV stands for comma-separated values.

2. Why would you declare `List<IEmployee>` instead of `ArrayList<HourlyEmployee>`?

> List<IEmployee> can hold any type of employees, which demonstrates the polymorphism feature of Java.

3. When you have one class referencing another object, such as storing that object as one of the attributes of the first class - what type of relationship is that called (between has-a and is-a)?

> It's a has-a relationship.

4. Can you provide an example of a has-a relationship in your code (if one exists)?

> The relationship between Class PayStub and Class IEmployee is has-a, since Class PayStub has an attribute employee, whose data type is IEmployee. 

5. Can you provide an example of an is-a relationship in your code (if one exists)?

> The relationship between Class HourlyEmployee and Class Employee is is-a, since Class HourlyEmployee extends Employee.

6. What is the difference between an interface and an abstract class?

> 1. An interface only has methods which need to be implemented. However, an abstract class can have attributes as well as methods.
> 2. All the methods of an interface are abstract. However, An abstract class can have concrete methods as well as abstract methods.
> 3. A class can implement many interfaces, but extend only one abstract class.

7. What is the advantage of using an interface over an abstract class?

> A class can implement many interfaces, but extend only one abstract class. In addition, interfaces defines contract without caring about the class hierarchy.

8. Is the following code valid or not? `List<int> numbers = new ArrayList<int>();`, explain why or why not. If not, explain how you can fix it. 

> It's invalid. Java generics only accept reference type(object). However, int is a primitive data type rather than a reference type. So we should replace int with its wrapper class Integer. The code can be modified as `List<Integer> numbers = new ArrayList<Integer>()`.

9. Which class/method is described as the "driver" for your application? 

> `public static void main(String[] args)` is the driver of our application.

10. How do you create a temporary folder for JUnit Testing? 

> We use `@TempDir` to create a temporary folder for Junit Testing.


## Deeper Thinking 

Salary Inequality is a major issue in the United States. Even in STEM fields, women are often paid less for [entry level positions](https://www.gsb.stanford.edu/insights/whats-behind-pay-gap-stem-jobs). However, not paying equal salary can hurt representation in the field, and looking from a business perspective, can hurt the company's bottom line has diversity improves innovation and innovation drives profits. 

Having heard these facts, your employer would like data about their salaries to ensure that they are paying their employees fairly. While this is often done 'after pay' by employee surveys and feedback, they have the idea that maybe the payroll system can help them ensure that they are paying their employees fairly. They have given you free reign to explore this idea.

Think through the issue / making sure to cite any resources you use to help you better understand the topic. Then write a paragraph on what changes you would need to make to the system. For example, would there be any additional data points you would need to store in the employee file? Why? Consider what point in the payroll process you may want to look at the data, as different people could have different pretax benefits and highlight that. 

The answer to this is mostly open. We ask that you cite at least two sources to show your understanding of the issue. The TAs will also give feedback on your answer, though will be liberal in grading as long as you show a good faith effort to understand the issue and making an effort to think about how your design to could help meet your employer's goals of salary equity. 

> Research on the gender wage gap uses regression analysis to isolate the effect of gender on pay by controlling for other variables. Blau and Kahn (2017) controlled for education, experience, race, region, occupation, industry, and union coverage, and found that **occupation and industry are the most important measurable factors** explaining the gender wage gap. Similarly, the Economic Policy Institute's analysis also controls for job tenure, parenthood, and marital status to separate legitimate pay differences from potential discrimination.
> 
> Based on these studies, our payroll system would need several additional data fields in the Employee class: `gender`, `race`, `jobTitle` (corresponding to occupation), `department` (corresponding to industry), `yearsOfExperience`, and `educationLevel`. These fields should also be added as new columns in `employees.csv` and reflected in `toCSV()` and `buildEmployeeFromCSV()`. With these variables, the system could compare pay rates across genders while controlling for other factors — if a significant gap remains after controlling for these factors, it may indicate unfair pay practices.
> 
> Regarding pretax deductions, different employees may choose different benefit plans (e.g., health insurance, retirement contributions), which affect net pay but not what the employer actually pays. Therefore, the equity analysis should compare **gross pay (pay rate)** rather than net pay to avoid misleading results. 
> 
> Sources:
> 1. Blau, F. D., & Kahn, L. M. (2017). "The Gender Wage Gap: Extent, Trends, and Explanations." *Journal of Economic Literature*, 55(3), 789-865. https://www.nber.org/papers/w21913
> 2. Economic Policy Institute. "What is the gender pay gap and is it real?" https://www.epi.org/publication/what-is-the-gender-pay-gap-and-is-it-real/
