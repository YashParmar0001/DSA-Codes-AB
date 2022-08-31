package com.company.StackClass.Part1;

import java.util.ArrayDeque;

public class InfixToPostPrefix {
    public static void main(String[] args) {
        String infix = "(2*3)-(4/8-6+7)";
        System.out.println(infixToPostfix(infix));
        System.out.println(infixToPrefix(infix));
        System.out.println(evaluatePostfix(infixToPostfix(infix)));
    }

    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    static int precedence(char c) {
        if (c == '+' || c == '-') return 1;
        else if (c == '*' || c == '/') return 2;
        else return -1;
    }

    static int calculate(int first, int second, char operator) {
        return switch (operator) {
            case '+' -> first + second;
            case '-' -> first - second;
            case '*' -> first * second;
            case '/' -> first / second;
            default -> 0;
        };
    }

    static String infixToPostfix(String infix) {
        StringBuilder ans = new StringBuilder();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (c == '(') stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    ans.append(stack.pop());
                }
                stack.pop();
            }else if (isOperator(c)) {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    ans.append(stack.pop());
                }
                stack.push(c);
            }else {
                ans.append(c);
            }
        }
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.toString();
    }

    static String infixToPrefix(String infix) {
        StringBuilder ans = new StringBuilder();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = infix.length()-1; i >= 0; i--) {
            char c = infix.charAt(i);
            if (c == ')') stack.push(c);
            else if (c == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    ans.append(stack.pop());
                }
                stack.pop();
            }else if (isOperator(c)) {
                while (!stack.isEmpty() && precedence(c) < precedence(stack.peek())) {
                    ans.append(stack.pop());
                }
                stack.push(c);
            }else {
                ans.append(c);
            }
        }
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }

    static int evaluatePostfix(String postfix) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (isOperator(c)) {
                int second = stack.pop();
                int first = stack.pop();
                int eval = calculate(first, second, c);
                stack.push(eval);
            }else {
                stack.push(c-'0');
            }
        }
        return stack.pop();
    }
}
