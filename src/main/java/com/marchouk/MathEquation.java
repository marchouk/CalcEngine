package com.marchouk;

public class MathEquation {
    private double leftVal;
    private double rightVal;
    private MathOperation opCode;
    private double result;

    private static int numberOfCalculations;
    private static double sumOfResults;

    public MathEquation() {
    }
    public MathEquation(MathOperation opCode) {
        this.opCode = opCode;
    }
    public MathEquation(MathOperation opCode, double leftVal, double rightVal) {
        this(opCode);
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    void execute() {
        switch(this.opCode) {
            case ADD:
                result = leftVal + rightVal;
                break;
            case SUBTRACT:
                result = leftVal - rightVal;
                break;
            case MULTIPLY:
                result = leftVal * rightVal;
                break;
            case DIVIDE:
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
                opCode.getSymbol() +
                " " +
                rightVal +
                " = " +
                result;
    }
}
