package oop;

public class Main {
    public static void main(String[] args) {
//        var textBox1 = new TextBox();
//        textBox1.setText("Box 1");
//        System.out.println(textBox1.text.toUpperCase());
//
//        var textBox2 = new TextBox();
//        textBox2.setText("Box 2");
//        System.out.println(textBox2.text);
//
//        var textBox3 = textBox1;
//
//        textBox3.setText("Hello World");
//        System.out.println(textBox1.text);


        // procedural programming
        int baseSalary = 50_000;
        int extraHours = 10;
        int hourlyRate = 20;

        int wage = calculateWage(baseSalary, extraHours, hourlyRate);
        System.out.println(wage);


//        var employee = new Employee();
//        employee.baseSalary = 50_0000;
//        employee.hourlyRate = 20;
//        int employeeWage = employee.calculateWage(10);
//        System.out.println("Class");
//        System.out.println(employeeWage);

        // encapsulated fields
//        var employee = new Employee();
//        employee.setBaseSalary(50_000);
//        employee.setHourlyRate(20);
//        System.out.println(employee.calculateWage(10));

        var browser = new Browser();
        browser.navigate("127.0.0.1");

        var fullEmployee = new Employee(50_000, 20);
        System.out.println(fullEmployee.calculateWage(10));
        System.out.println(fullEmployee.calculateWage());
        var employeeWithoutHourlyRate = new Employee(50_000);

        // static fields and methods
        System.out.println(Employee.numberOfEmployees);
        Employee.printNumberOfEmployees();

    }

    public static int calculateWage(
            int baseSalary,
            int extraHours,
            int hourlyRate
    ) {
        return baseSalary + (extraHours * hourlyRate);
    }
}
