package interfaces;

public class Main {
    public static void main(String[] args) {
        // constructor dependency injection
        var calculator = new TaxCalculator2018(100_000);
        var report = new TaxReport();

        report.show(calculator);

        report.show(new TaxCalculator2019());

    }
}
