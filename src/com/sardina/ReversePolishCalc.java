package com.sardina;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReversePolishCalc {

    // You'll need a variable here to keep track of the top of the stack
    Stack<String> tokens = new Stack<>();     // private String[] tokens; =>The array of the input string split up
    Stack<String> mainStack = new Stack<>();
//    private String[] stack;     // The stack

    public double calculate(String input) {
        System.out.println("***** just inside 'calculate' ******");
        // 1. Use the String split method to split the string into tokens at the commas
//        tokens = ...


   // SOLUTION TO PROBLEM IS TO REVERSE THIS ARRAY SO THAT POP IS LIFO. CURRENTLY FIFO.
        for (String character : input.split(",")) {
            tokens.push(character);
            System.out.println("Loop splitting String input should be x3");
        }
// ^^^^^^^^^^^^^^^^^ FIX ABOVE ^^^^^^^^^^^^^^^^^^^^^^^^^


        //DEBUGGING BELOW
        System.out.println("----- 3 tokens below ----");
        for(String token: tokens) {
            System.out.println(token);
        }
        System.out.println("Check popping: ");
        System.out.println(tokens.pop());

        //DEBUGGING ABOVE

        // 2. Allocate a stack as big as the number of tokens
//        stack = tokens.toArray(new String[tokens.size()]);

        // 3. write the algorithm
//        for(int i = 0; i < tokens.length; ++i) {
//            // calls to push() and pop() and do the math here
//        }
        for(int i = 0; i < tokens.size(); i++) {
            if (isOperator(tokens.get(i)) == false) {
                    System.out.println("!!! MAIN LOOP !!!");
                    System.out.println("tokens at i ");
                    System.out.println(tokens.get(i));
                mainStack.push(tokens.pop());
                    System.out.println("stack at i ");
                    System.out.println(mainStack.get(i));
                }
            else {
                String currentOperator = tokens.get(i);
                    System.out.println(currentOperator);
                    System.out.println("----- tokens.get(i) -----");
                    System.out.println(tokens.get(i));
                    System.out.println("----- currentOperator ------");
                    System.out.println(currentOperator);
                String input1 = mainStack.pop();
                    System.out.println("----- input1 = stack.pop() -----");
                    System.out.println(input1);
                String input2 = mainStack.pop();
                    System.out.println("----- input1 = stack.pop() -----");
                    System.out.println(input2);
                String pushBackToTokens = Double.toString(whichOperator(currentOperator, input1, input2));
                    System.out.println("----- pushBackToTokens -----");
                    System.out.println(pushBackToTokens);
                tokens.push(pushBackToTokens);
                for (String thing : mainStack) {
                    mainStack.push(thing);
                }
            }
            }


        // 4. return the result
        return Double.parseDouble(tokens.pop());
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
        if (inputOperator == "+") return addFn(num1, num2);
        else if (inputOperator == "-") return subtractFn(num1, num2);
        else if (inputOperator == "*") return multiplyFn(num1, num2);
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

//ORIGINAL METHODS FROM STARTER FILES
//    private void push(String number) {
//        // push on the stack
//    }

//    private void push(double d) {
//        // change the double to a string and then push it on the stack
//    }
//
//    private double pop() {
//        // remove the string from the top of the stack and convert it to a double and return it
//        return 4.4; //JUST TO RUN OTHER CODE REMOVE
//    }




}
