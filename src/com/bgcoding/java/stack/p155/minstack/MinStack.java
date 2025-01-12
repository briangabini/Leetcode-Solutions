package com.bgcoding.java.stack.p155.minstack;

import java.util.Stack;

// One Stack - Variation 1
// Optimal Solution
// Time: O(1)
// Space: O(n)
class MinStack {

    private Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (!stack.empty()) {
            // check previous min
            int previousMin = stack.peek()[1];
            int newMin = Math.min(val, previousMin);
            stack.push(new int[]{val, newMin});
        } else {
            stack.push(new int[]{val, val});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
