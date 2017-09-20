package com.sardina;

import java.util.*;

public class ReversePolishCalc {

    Deque<String> tokens = new ArrayDeque<>();
    Deque<String> stack = new ArrayDeque<>();
    Deque<String> usedOperators = new ArrayDeque<>();

    public double calculate(String input) {

        for(String character : input.split(",") ) {
            tokens.add(character);
        }

        for (String token: tokens) {
            if(isOperator((token))) {
                usedOperators.push(tokens.pop());
                String input2 = stack.pop();
                String input1 = stack.pop();
//                String pushBackToStack = Double.toString(whichOperator(token, input1, input2));
                stack.push(Double.toString(whichOperator(token, input1, input2)));
//                stack.push(pushBackToStack);

            }
            else {
                stack.push(tokens.pop());
            }
        }//end forEach loop

        return Double.parseDouble(stack.pop());
    }

//CHECK FOR OPERATOR
    private Boolean isOperator(String input) {
        String[] operators = {"+", "-", "/", "*"};
        for(String operator : operators) {
            if(input.equals(operator)) {
                return true;
            } }return false; }

//AFTER BOOL isOperator, DETERMINES WHICH ONE AND PERFORMS MATH FUNCTION
    private Double whichOperator(String inputOperator, String num1, String num2) {
        if (inputOperator.equals("+")) return addFn(num1, num2);
        else if (inputOperator.equals("-")) return subtractFn(num1, num2);
        else if (inputOperator.equals("*")) return multiplyFn(num1, num2);
        else return divideFn(num1, num2);
    }

//MATH FN's

    private Double addFn(String input1, String input2) {
        return Double.parseDouble(input1) + Double.parseDouble(input2);
    }

    private Double subtractFn(String input1, String input2) {
        return Double.parseDouble(input1) - Double.parseDouble(input2);
    }

    private Double multiplyFn(String input1, String input2) {
        return Double.parseDouble(input1) * Double.parseDouble(input2);
    }
    private Double divideFn(String input1, String input2) {
        return Double.parseDouble(input1) / Double.parseDouble(input2);
    }


}
