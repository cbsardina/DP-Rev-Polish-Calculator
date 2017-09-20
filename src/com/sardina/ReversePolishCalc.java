package com.sardina;

import java.util.*;

public class ReversePolishCalc {

    // You'll need a variable here to keep track of the top of the stack
//    Stack<String> tokens = new Stack<>();
//    Stack<String> stack = new Stack<>();
    Deque<String> tokens = new ArrayDeque<>();
    Deque<String> stack = new ArrayDeque<>();
//    private String[] stack;     // The stack

    public double calculate(String input) {
        // 1. Use the String split method to split the string into tokens at the commas
//        tokens = ...


   // SOLUTION TO PROBLEM IS TO REVERSE THIS ARRAY SO THAT POP IS LIFO. CURRENTLY FIFO.
//        for (String character : input.split(",")) {
//            tokens.push(character);
//            System.out.println("Loop splitting String input should be x3");
//        }
// ^^^^^^^^^^^^^^^^^ FIX ABOVE ^^^^^^^^^^^^^^^^^^^^^^^^^

    //Split string insert into arrayDeque then insert into a stack with while loop
        for(String character : input.split(",") ) {
            tokens.add(character);
        }
        System.out.println("tokens after creation: " + tokens);
        System.out.println("stack at same time: " + stack);

//        int indx = 0;
//        while (indx < deque.size()) {
//            tokens.push(deque.pop()); }
//
//        System.out.println(tokens);


        // 2. Allocate a stack as big as the number of tokens
//        stack = tokens.toArray(new String[tokens.size()]);

        // 3. write the algorithm
//        for(int i = 0; i < tokens.length; ++i) {
//            // calls to push() and pop() and do the math here
//        }

        for (String token: tokens) {
            String temp = tokens.pop();
            System.out.println("token/temp : " + temp);
            if(isOperator((temp)) == false) {
                stack.push(temp);
                System.out.println("Stack : " + stack);
            }
            else {
                String currentOperator = temp;
                System.out.println("currentOperator = temp : " + currentOperator);
                String input1 = stack.pop();
                System.out.println("input1: " + input1);
                String input2 = stack.pop();
                System.out.println("input2: " + input2);
                Double calculation = whichOperator(currentOperator, input1, input2);
                System.out.println("calculation from whichOperator: " + calculation);
                String pushBackToTokens = Double.toString(whichOperator(currentOperator, input1, input2));
                tokens.push(pushBackToTokens);
                for (String thing: stack) {
                    tokens.push(thing);
                }
            }
        }//end forEach loop

//old FN may revisit -------------------------------
//        int idx = 0;
//        while (idx < tokens.size()) {
//            if (isOperator(tokens.get(tokens.size())) == false) {
//                    System.out.println("!!! MAIN LOOP !!!");
//                    System.out.println("tokens at i " + tokens);
//                stack.push(tokens.pop());
//                    System.out.println("stack at i " + stack);
//            } //end if
//            else {
//                String currentOperator = tokens.get(tokens.size());
//                    System.out.println("else: currentOperator: " + currentOperator);
//                String input1 = stack.pop();
//                    System.out.println("input1 = stack.pop() : " + input1);
//                String input2 = stack.pop();
//                    System.out.println("input2 = stack.pop() : " + input2);
//                String pushBackToTokens = Double.toString(whichOperator(currentOperator, input1, input2));
//                    System.out.println("pushBackToTokens after calculations : " + pushBackToTokens);
//                tokens.push(pushBackToTokens);
//                for (String thing : stack) {
//                    tokens.push(thing);
//                } //end small for loop
//            }//end else
//        } //end while loop
//old above may revisit ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^


//        for(int i = 0; i < tokens.size(); i++) {
//            System.out.println("tokens size: " + tokens.size());
//        if (isOperator(tokens.get(tokens.size())) == false) {
//            System.out.println("tokens at i " + tokens);
//            stack.push(tokens.pop());
//            System.out.println("stack at i " + stack);
//        } //end if
//        else {
//            String currentOperator = tokens.get(tokens.size());
//            System.out.println("else: currentOperator: " + currentOperator);
//            String input1 = stack.pop();
//            System.out.println("input1 = stack.pop() : " + input1);
//            String input2 = stack.pop();
//            System.out.println("input2 = stack.pop() : " + input2);
//            String pushBackToTokens = Double.toString(whichOperator(currentOperator, input1, input2));
//            System.out.println("pushBackToTokens after calculations : " + pushBackToTokens);
//            tokens.push(pushBackToTokens);
//            for (String thing : stack) {
//                tokens.push(thing);
//            } //end small for loop
//        }//end else
////
//            }//end for loop


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
