package com.marchouk;

public class MathEquation {
    private double leftVal;
    private double rightVal;
    private char opCode;
    private double result;

    private static int numberOfCalculations;
    private static double sumOfResults;

    public MathEquation() {
    }
    public MathEquation(char opCode) {
        this.opCode = opCode;
    }
    public MathEquation(char opCode, double leftVal, double rightVal) {
        this(opCode);
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    void execute() {
        switch(this.opCode) {
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
        numberOfCalculations++;
        sumOfResults += result;
    }

    void execute(double leftVal, double rightVal) {
        System.out.println("Using execute overloads doubles");
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        execute();
    }

    void execute(int leftVal, int rightVal) {
        System.out.println("Using execute overloads Int");
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        execute();

        result = (int) result;
    }

    public static double getAverageResult() {
        return sumOfResults / numberOfCalculations;
    }
    public double getResult() {
        return result;
    }

    @Override
    public String toString() {
        return  leftVal +
                " " +
                symbolFromOpCode() +
                " " +
                rightVal +
                " = " +
                result;
    }

    private char symbolFromOpCode() {
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
}
