package oop;

public class Employee {
    private int baseSalary;
    private int hourlyRate;

    public static int numberOfEmployees;

    public static void printNumberOfEmployees() {
        System.out.println(numberOfEmployees);
    }


    // add constructor.
    // constructor is public method with the same name as class
    public Employee(int baseSalary, int hourlyRate) {
        setBaseSalary(baseSalary);
        setHourlyRate(hourlyRate);
        numberOfEmployees++;
    }

    public Employee(int baseSalary) {
        this(baseSalary, 0);
//        setBaseSalary(baseSalary);
//        setHourlyRate(0);
    }

    // overloading method only as an example here;
    // overload methods only when should accept different data types
    public int calculateWage(int extraHours) {
        return baseSalary + (extraHours * getHourlyRate());
    }
    public int calculateWage() {
        return calculateWage(0);
    }

    private int getBaseSalary() {
        return baseSalary;
    }

    private void setBaseSalary(int baseSalary) {
        if (baseSalary <= 0)
            throw new IllegalArgumentException("Salary cannot be 0 or less.");
        this.baseSalary = baseSalary;
    }

    private int getHourlyRate() {
        return hourlyRate;
    }

    private void setHourlyRate(int hourlyRate) {
        if (hourlyRate < 0) {
            throw new IllegalArgumentException("Hourly rate cannot be 0 or less.");
        }
        this.hourlyRate = hourlyRate;
    }
}
