package com.bgcoding.java.p128.longestconsecutivesequence;

import java.util.Arrays;

// Second attempt
// O(nlogn)
class Solution2 {
    public int longestConsecutive(int[] nums) {
        final int n = nums.length;
        if (n == 0) return 0;
        Arrays.sort(nums);

        int res = 0;
        int streak = 0;
        int curr = nums[0];
        int i = 0;

        while (i < n) {
            // if the current num changed, and it's not a sequence
            if (curr != nums[i]) {
                streak = 0;
                curr = nums[i];
            }

            // increment i, until reaching a new number
            while (i < n && nums[i] == curr) {
                i++;
            }

            curr++;
            streak++;
            res = Integer.max(streak, res);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int[] ex1 = {0, 0, 1, 3};
        System.out.println("Example 1: " + solution.longestConsecutive(ex1));
    }
}
