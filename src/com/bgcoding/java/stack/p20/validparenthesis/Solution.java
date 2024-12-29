package com.bgcoding.java.stack.p20.validparenthesis;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {
        if (s.isEmpty()) return true;
        Map<Character, Character> closeMap = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        // fill the map with closing symbols
        closeMap.put(')', '(');
        closeMap.put('}', '{');
        closeMap.put(']', '[');

        for (char c : s.toCharArray()) {
            if (closeMap.containsKey(c)) {
                if (!stack.isEmpty() && closeMap.get(c) == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "()";
        System.out.println(solution.isValid(s));
    }
}
