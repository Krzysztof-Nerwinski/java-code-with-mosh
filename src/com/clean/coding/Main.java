package com.clean.coding;

import com.sun.source.tree.BreakTree;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    static NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.of("pl", "PL"));
    final static byte MONTHS_IN_YEAR = 12;

    public static void main(String[] args) {
//        String greeting = greetUser("Jan", "Kowalski");
//        System.out.println(greeting);

        // refactoring
//        mortgageCalculatorWithErrorHandling();

        paymentSchedule();

    }

    public static void paymentSchedule() {

        int principal = (int) readNumber("Principal($PLN - $PLN): ", 1000, 1_000_000);
        float annualInterest = (float) readNumber("Annual interest Rate (1-30): ", 1, 30);
        byte years = (byte) readNumber("Period (Years 1-30): ", 1, 30);
        float monthlyInterestRate = annualInterest / MONTHS_IN_YEAR / 100;
        int numberOfRates = years * MONTHS_IN_YEAR;

        double calculatedMortgage = calculateMortgageForLoan(principal, monthlyInterestRate, numberOfRates);
        printMortgageInfo("Mortgage: " + calculatedMortgage);

        printPaymentSchedule(principal, principal, monthlyInterestRate, numberOfRates);

        System.out.println("Paid whole interest of: " + currency.format(principal));

    }

    private static void printMortgageInfo(String calculatedMortgage) {
        System.out.println("--------------------");
        System.out.println(calculatedMortgage);
        System.out.println("--------------------");
    }

    private static void printPaymentSchedule(int principal, double remainingLoanBalance, float monthlyInterestRate, int numberOfRates) {
        printMortgageInfo("PAYMENT SCHEDULE");
        int paidRates = 0;
        while (remainingLoanBalance > 0) {
            remainingLoanBalance = calculateRemainingLoanBalance(principal, monthlyInterestRate, numberOfRates, paidRates);
            paidRates++;
        }
    }

    public static double calculateRemainingLoanBalance(int principal, float monthlyInterestRate, int numberOfRates, int paidRates) {
        float monthlyRate = 1 + monthlyInterestRate;

        double remainingLoanBalance = principal
                * (Math.pow(monthlyRate, numberOfRates) - Math.pow(monthlyRate, paidRates))
                / (Math.pow(monthlyRate, numberOfRates) - 1);

        System.out.println("Remaining loan: " + currency.format(remainingLoanBalance));

        return remainingLoanBalance;
    }

    public static void mortgageCalculatorWithErrorHandling() {
        System.out.println("Please provide following data");

        int principal = (int) readNumber("Principal(1K PLN - 1M PLN): ", 1000, 1_000_000);
        float annualInterest = (float) readNumber("Annual interest Rate (1-30): ", 1, 30);
        byte years = (byte) readNumber("Period (Years 1-30): ", 1, 30);

        double calculatedMortgage = calculateMortgage(principal, annualInterest, years);

        String result = "Mortgage: " + currency.format(calculatedMortgage);
        System.out.println(result);
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value = 0;
        while (value < min || value > max) {
            System.out.print(prompt);
            value = scanner.nextDouble();
        }
        return value;
    }

    public static double calculateMortgage(int principal,
                                           float annualInterest,
                                           byte years) {
        int numberOfRates = years * MONTHS_IN_YEAR;
        float monthlyAnnualInterestRate = annualInterest / MONTHS_IN_YEAR / 100;
        double power = Math.pow(monthlyAnnualInterestRate + 1, numberOfRates);
        return principal
                * (monthlyAnnualInterestRate * power
                / (power - 1));
    }

    public static double calculateMortgageForLoan(int principal,
                                                  float monthlyInterestRate,
                                                  int numberOfRates) {
        double power = Math.pow(monthlyInterestRate + 1, numberOfRates);
        return principal
                * (monthlyInterestRate * power
                / (power - 1));
    }


    public static String greetUser(String firstName, String lastName) {
        return "Hello " + firstName + " " + lastName;
    }

}
