package com.bgcoding.java.twopointers.p11.containerwithmostwater;

// 2nd attempt
// Using Two-pointer approach
// Time: O(n)
public class Solution2 {
    public int maxArea(int[] height) {
        int res = 0;

        // init pointers
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int diff = right - left;
            int minHeight = Integer.min(height[left], height[right]);
            int currArea = minHeight * diff;
            res = Integer.max(res, currArea);

            if (minHeight == height[left]) left++;
            else right--;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
