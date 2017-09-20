package com.sardina;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReversePolishCalc {

    // You'll need a variable here to keep track of the top of the stack
    Stack<String> tokens = new Stack<>();     // private String[] tokens; =>The array of the input string split up
    private String[] stack;     // The stack

    public double calculate(String input) {

        // 1. Use the String split method to split the string into tokens at the commas
//        tokens = ...

        for (String character : input.split(",")) {
            tokens.add(character);
        }

        // 2. Allocate a stack as big as the number of tokens
        stack = tokens.toArray(new String[tokens.size()]);

        // 3. write the algorithm
        for(int i = 0; i < tokens.length; ++i) {
            // calls to push() and pop() and do the math here
        }

        // 4. return the result
        return pop();
    }

//CHECK FOR OPERATOR
    private boolean isOperator(String input) {
        String[] operators = {"+", "-", "/", "*"};
        for(String operator : operators) {
            if(input.equals(operator)) {
                return true;
            } }return false; }

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

//ORIGINAL METHODS FROM STARTER FILES
    private void push(String number) {
        // push on the stack
    }

    private void push(double d) {
        // change the double to a string and then push it on the stack
    }

    private double pop() {
        // remove the string from the top of the stack and convert it to a double and return it
        return 4.4; //JUST TO RUN OTHER CODE REMOVE
    }




}
