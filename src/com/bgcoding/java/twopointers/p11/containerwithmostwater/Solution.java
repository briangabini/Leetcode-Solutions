package com.bgcoding.java.twopointers.p11.containerwithmostwater;

// 1st attempt
// Brute force
// Time: O(n^2)
public class Solution {
    public int maxArea(int[] height) {
        int res = 0;

        for (int i = 0; i < height.length - 1; i++) {

            // i is fixed (left pillar)
            for (int j = i + 1; j < height.length; j++) {
                // j adjusts
                // check which element is higher
                int diff = j - i;
                int min = Integer.min(height[i], height[j]);
                res = Integer.max(res, min * diff);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(solution.maxArea(new int[]{1, 5, 4, 2, 3, 4, 3, 5, 1, 2}));
    }
}
