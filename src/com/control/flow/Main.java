package com.control.flow;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        equality();
//        logicalOperators();
//        ifStatements();
//        simplifiedIfStatements();
//        terneryOperators();
//        switchStatements();
//        fizzBuzzExercise();
//        forLoops();
//        whileLoops();
//        doWhileLoops();
//        breakAndContinueStatements();
//        forEachLoop();
        mortgageCalculatorWithErrorHandling();


    }

    public static void mortgageCalculatorWithErrorHandling() {
        Scanner scanner = new Scanner(System.in);

        final byte MONTHS_IN_YEAR = 12;

        System.out.println("Please provide following data");
        int principal = 0;
        while (principal < 1000 || principal > 1_000_000) {
            System.out.print("Principal($1K - $1M): ");
            principal = scanner.nextInt();
        }
        float monthlyAnnualInterestRate = 0;
        while (monthlyAnnualInterestRate <= 0 || monthlyAnnualInterestRate > 30) {
            System.out.print("Annual interest Rate (more than 0 less than equal 30): ");
            monthlyAnnualInterestRate = scanner.nextFloat();
        }
        monthlyAnnualInterestRate = monthlyAnnualInterestRate / MONTHS_IN_YEAR / 100;
        byte years = 0;
        while (years < 1 || years > 30) {
            System.out.print("Period (Years 1-30): ");
            years = scanner.nextByte();
        }
        double power = Math.pow(monthlyAnnualInterestRate + 1, years * MONTHS_IN_YEAR);
        double calculatedMortgage = principal
                * (monthlyAnnualInterestRate * power
                / (power - 1));


        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result = "Mortgage: " + currency.format(calculatedMortgage);
        System.out.println(result);
    }


    public static void forEachLoop() {
        String[] fruits = {"Apple", "Mango", "Orange"};
        for (int i = 0; i < fruits.length; i++) {
            System.out.println(fruits[i]);
        }

        for (String fruit : fruits) {
            System.out.println(fruit);
        }

    }

    public static void breakAndContinueStatements() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (true) {
            System.out.print("input: ");
            input = scanner.next().toLowerCase();
            if (input.equals("pass"))
                continue;
            if (input.equals("quit"))
                break;

            System.out.println(input);
        }
    }

    public static void doWhileLoops() {
        int i = 0;
        do {
            System.out.println("Loop no: " + (i + 1));
            i++;
        } while (i < 5);
    }

    public static void whileLoops() {
        int i = 5;
        while (i > 0) {
            System.out.println("Hello world");
            i--;
        }

        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!input.equals("quit")) {
            System.out.print("input: ");
            input = scanner.next().toLowerCase();
            System.out.println(input);
        }
    }

    public static void forLoops() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Loop no: " + (i + 1));
        }
    }

    public static void fizzBuzzExercise() {
        Scanner scanner = new Scanner(System.in);
        final String fizz = "Fizz";
        final String buzz = "Buzz";

        System.out.print("Number: ");
        int number = scanner.nextInt();
        if (number % 5 == 0 && number % 3 == 0) {
            System.out.println(fizz + buzz);
        } else if (number % 5 == 0) {
            System.out.println(fizz);
        } else if (number % 3 == 0) {
            System.out.println(buzz);
        } else {
            System.out.println(number);
        }

    }

    public static void switchStatements() {
        String role = "admin";
        if (role == "admin") {
            System.out.println("You're an admin");
        } else if (role == "moderator") {
            System.out.println("You're an moderator");
        } else {
            System.out.println("You're a regular user");
        }

        switch (role) {
            case "admin":
                System.out.println("You're an admin");
                break;
            case "moderator":
                System.out.println("You're an moderator");
                break;
            default:
                System.out.println("You're a regular user");
        }

    }

    public static void terneryOperators() {
        int income = 120_000;
        String className = income > 100_00 ? "First class" : "Economy";
        System.out.println(className);
    }

    public static void simplifiedIfStatements() {
        int income = 120_000;
        boolean hasHighIncome = income > 100_000;
        System.out.println(hasHighIncome);
    }

    public static void ifStatements() {
        int temperature = 32;
        if (temperature > 30) {
            System.out.println("It's a hot day");
            System.out.println("Drink plenty of water");
        } else if (temperature > 20) {
            System.out.println("It's a beautiful day");
        } else {
            System.out.println("It's a cold day");
        }

    }

    public static void logicalOperators() {
        int temperature = 22;
        boolean isWarm = temperature > 20 && temperature < 30;
        System.out.println(isWarm);

        boolean hasHighIncome = false;
        boolean hasGoodCredit = true;
        boolean isEligible = hasHighIncome || hasGoodCredit;
        System.out.println(isEligible);

        boolean hasCriminalRecord = false;
        boolean isEligibleFull = !hasCriminalRecord && (hasHighIncome || hasGoodCredit);
        System.out.println(isEligibleFull);
    }


    public static void equality() {

        int x = 1;
        int y = 1;
        System.out.println(x == y);
        System.out.println(x != y);
        System.out.println(x > y);
        System.out.println(x >= y);
        System.out.println(x < y);
        System.out.println(x <= y);
    }
}
