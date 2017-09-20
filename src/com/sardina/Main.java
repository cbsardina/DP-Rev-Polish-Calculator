package com.sardina;

public class Main {

    public static void main(String[] args) {

        ReversePolishCalc rpc = new ReversePolishCalc();

        // Tests below

        String rpnExpression = "2.5,4.8,+";
        double expectedResult = 7.3;
        double actualResult = rpc.calculate(rpnExpression);
        checkResult(rpnExpression, expectedResult, actualResult);

        rpnExpression = "5,1,2,+,4,*,+,3,-";
        expectedResult = 14.0;
        actualResult = rpc.calculate(rpnExpression);
        checkResult(rpnExpression, expectedResult, actualResult);

        rpnExpression = "3,11,5,+,-";
        expectedResult = -13.0;
        actualResult = rpc.calculate(rpnExpression);
        checkResult(rpnExpression, expectedResult, actualResult);

        rpnExpression = "14,8,*,13,3,/,-";
        expectedResult = 107.6666666666666666666667;
        actualResult = rpc.calculate(rpnExpression);
        checkResult(rpnExpression, expectedResult, actualResult);

        rpnExpression = "7,50,10,/,*,4,-";
        expectedResult = 31.0;
        actualResult = rpc.calculate(rpnExpression);
        checkResult(rpnExpression, expectedResult, actualResult);
    }

    private static void checkResult(String expression, double expected, double actual) {
        if (expected == actual) {
            System.out.println("SUCCESS: " + expression + " is " + expected);
        } else {
            System.out.println("ERROR: " + expression + " expected " + expected + " actual " + actual);
        }
    }
}
