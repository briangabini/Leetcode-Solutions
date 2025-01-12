package com.bgcoding.java.stack.p150.reverse_polish_notation;

import java.util.Stack;

public class Solution {

    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();
        int res = 0;

        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }

        for (String token : tokens) {

            if (!token.matches("[-+*/]")) {
                operands.push(Integer.parseInt(token));
            } else {
                char operator = token.charAt(0);
                int b = operands.pop();
                int a = operands.pop();

                switch(operator) {
                    case '-': res = a - b; break;
                    case '+': res = a + b; break;
                    case '/': res = a / b; break;
                    case '*': res = a * b; break;
                }

                operands.push(res);
            }
        }

        return res;
    }
}
