package com.codewithmosh;

import javax.management.NotCompliantMBeanException;
import java.awt.*;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        primitives();
//        references();
//        differences();
//        strings();
//        escapeSequences();
//        arrays();
//        multiDimensionalArrays();
//        constants();
//        arithmeticExpressions();
//        orderOfOperations();
//        casting();
//        mathClass();
//        formattingNumbers();
//        readingInput();
        mortgageCalculator();
    }

    public static void primitives() {
        byte age = 30;
        long viewsCount = 3_123_456_789L;
        float price = 10.99F;
        char letter = 'A';
        boolean isEligible = true;

        System.out.println(age);
    }

    public static void references() {
        Date now = new Date();
        System.out.println(now);
    }

    public static void differences() {
//        byte x = 1;
//        byte y = x;
//        x = 2;
//        System.out.println(x);
//        System.out.println(y);

        // primitives are copied by value
        // reference types are copied by reference
        Point point1 = new Point(1, 1);
        Point point2 = point1;
        point1.x = 5;
        System.out.println(point2);
    }

    public static void strings() {
        String message = "  Hello world" + "!!";
        boolean messagesEndsWithExclamation = message.endsWith("!!");
        int length = message.length();
        int index = message.indexOf("G");
        int nonExistingIndex = message.indexOf("sky");
        String lowerCaseMessage = message.toLowerCase();
        String trimmedMessage = message.trim();
        String replacedMessage = message.replace("!", "*");
        System.out.println(message);
        System.out.println(replacedMessage);
        System.out.println(trimmedMessage);
    }

    public static void escapeSequences() {
        String message = "Hello \"Mosh\"";
        System.out.println(message);

        String windowsPath = "C:\\someDir\\";
        System.out.println(windowsPath);

        String messageWithLines = "First line \nSecond line\tafter tab text";
        System.out.println(messageWithLines);
    }

    public static void arrays() {
//        int[] numbers = new int[5];
//        numbers[0] = 1;
//        numbers[1] = 2;
//        System.out.println(numbers.length);
//        numbers[10] = 2;
//          invalid index raises Exception

        int[] numbers = {7, 5, 11, 23};

        System.out.println(numbers.length);

        System.out.println(Arrays.toString(numbers));
        // sorting in place
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static void multiDimensionalArrays() {
        // old way
//        int[][] numbers = new int[2][3];
//
//        numbers[0][0] = 1;
//        System.out.println(Arrays.deepToString(numbers));

        // new way
        int[][] numbers = {{1, 2, 3}, {4, 5, 6}};

        System.out.println(Arrays.deepToString(numbers));
    }

    public static void constants() {
        final float pi = 3.14F;
        // to declare constant use "final"
    }

    public static void arithmeticExpressions() {
        int addResult = 10 + 3;
        System.out.println(addResult);
        int subtractionResult = 10 - 3;
        System.out.println(subtractionResult);
        int multiplyResult = 10 * 3;
        System.out.println(multiplyResult);

        int divisionResult = 10 / 3;
        System.out.println(divisionResult);

        // to get float division result cast to float or double
        float floatDivisionResult = (float) 10 / (float) 3;
        System.out.println(floatDivisionResult);

        int x = 1;
        x++;
        ++x;
        System.out.println(x);

        int y = x++;
        System.out.println(x);
        System.out.println(y);

        int z = ++x;
        System.out.println(x);
        System.out.println(z);

        int a = 1;
        a += 1;
        a -= 1;
        System.out.println(a);

        a *= 2;
        a /= 2;
        System.out.println(a);
    }

    public static void orderOfOperations() {
        int x = 10 + 3 * 2;
        System.out.println(x);
        int y = (10 + 3) * 2;
        System.out.println(y);
    }

    public static void casting() {
        // Implicit casting byte > short > int > long > float > double
        short x = 1;
        int y = x + 2;
        System.out.println(y);

        // explicit casting only between compatible types
        double a = 1.1;
        int b = (int) a + 2;
        System.out.println(b);

        String c = "1";
        int d = Integer.parseInt(c) + 2;
        System.out.println(d);

        String e = "1.1";
        double f = Double.parseDouble(e) + 2;
        System.out.println(f);
    }

    public static void mathClass() {
        int a = Math.round(5.55F);
        System.out.println(a);

        int b = (int) Math.ceil(5.5F);
        System.out.println(b);

        int c = (int) Math.floor(5.5F);
        System.out.println(c);

        int max = Math.max(1, 3);
        System.out.println(max);
        int min = Math.min(1, 3);
        System.out.println(min);

        double random = Math.random() * 100;
        System.out.println(random);

        int randomInt = (int) Math.round(random);
        System.out.println(randomInt);
    }

    public static void formattingNumbers() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result = currency.format(12345767.891);
        System.out.println(result);

        String stringPercent = NumberFormat.getPercentInstance().format(0.56);
        System.out.println(stringPercent);
    }

    public static void readingInput() {
        Scanner scanner = new Scanner(System.in);
//        System.out.print("Name: ");
//        String name = scanner.next();
        System.out.print("Full name: ");
        String fullName = scanner.nextLine().trim();
        System.out.print("Age: ");
        short age = scanner.nextShort();
        System.out.print("Your name is: " + fullName + " and your age is: " + age);
    }

    public static void mortgageCalculator() {
        Scanner scanner = new Scanner(System.in);

        final byte MONTHS_IN_YEAR = 12;

        System.out.println("Please provide following data");
        System.out.print("Principal: ");
        int principal = scanner.nextInt();
        System.out.print("Annual interest Rate: ");
        float monthlyAnnualInterestRate = scanner.nextFloat() / MONTHS_IN_YEAR / 100;
        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();
        float annualInterestRatePlusOne = monthlyAnnualInterestRate + 1;
        double power = Math.pow(annualInterestRatePlusOne, years * MONTHS_IN_YEAR);
        double calculatedMortgage = principal
                * (monthlyAnnualInterestRate * power
                / (power - 1));


        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result = "Mortgage: " + currency.format(calculatedMortgage);
        System.out.println(result);

    }
}
