package com.marchouk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
        double[] rightVals = {92.0d, 50.0d, 17.0d, 3.0d};
        char[] opCodes = {'d', 'a', 's', 'm'};
        double[] results = new double[opCodes.length];

        if (args.length == 0) {
            for (int i = 0; i < opCodes.length; i++) {
                results[i] = execute(opCodes[i], leftVals[i], rightVals[i]);
            }

            for (double result : results) {
                System.out.println(result);
            }
        } else if (args.length == 1 && args[0].equals("interactive")) {
            executeInteractively();
        } else if (args.length == 3) {
            handleCommandLine(args);
        } else {
            System.out.println("Please provide an operation and 2 numeric values!");
        }

    }

    private static char symbolFromOpCode(char opCode) {
        char[] opCodes = {'a', 's', 'm', 'd'};
        char[] symbols = {'+', '-', '*', '/'};
        char symbol = ' ';
        for (int i = 0; i < opCodes.length; i++) {
            if (opCode == opCodes[i]) {
                symbol = symbols[i];
                break;
            }
        }

        return symbol;
    }

    private static void handleCommandLine(String[] args) {
        char opCode = args[0].charAt(0);
        double leftVal = Double.parseDouble(args[1]);
        double rightVal = Double.parseDouble(args[2]);

        System.out.println(execute(opCode, leftVal, rightVal));
    }

    static void executeInteractively() {
        System.out.println("Enter an operation and two numbers");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");

        performOperation(parts);

    }

    private static void performOperation(String[] parts) {
        char opCode = opCodeFromString(parts[0]);
        double leftVal = valueFromWord(parts[1]);
        double rightVal = valueFromWord(parts[2]);
        
        double result = execute(opCode, leftVal, rightVal);

        displayResult(opCode, leftVal, rightVal, result);
    }

    private static void displayResult(char opCode, double leftVal, double rightVal, double result) {
        char symbol = symbolFromOpCode(opCode);
        StringBuilder stringBuilder = new StringBuilder(40);
        stringBuilder.append(leftVal);
        stringBuilder.append(" ");
        stringBuilder.append(symbol);
        stringBuilder.append(" ");
        stringBuilder.append(rightVal);
        stringBuilder.append(" = ");
        stringBuilder.append(result);

        String output = stringBuilder.toString();
        System.out.println(output);
    }

    public static double execute(char opCode, double leftVal, double rightVal) {
        double result;
        switch(opCode) {
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            case 'd':
                result = rightVal != 0 ? leftVal / rightVal : 0.0d;
                break;
            default:
                System.out.println("Invalid opCode: " + opCode);
                result = 0.0d;
        }

        return result;
    }

    static char opCodeFromString(String operationName) {
        return operationName.charAt(0);
    }

    static double valueFromWord(String word) {
        String[] numberWords = {
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"
        };

        double value = 0d;
        for (int i = 0; i < numberWords.length; i++) {
            if (word.equals(numberWords[i])) {
                value = i;
                break;
            }
        }

        return value;
    }
}
