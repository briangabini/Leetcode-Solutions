package com.bgcoding.java.p128.longestconsecutivesequence;

import java.util.*;

// 3rd attempt
// Using Hashmap
// O(n)
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        // 1. add all values to the set
        for (int num : nums) {
            numSet.add(num);
        }
        int longest = 0;

        for (int num : numSet) {
            // only consider values without left neighbors (start of the sequence)
            if (!numSet.contains(num - 1)) {
                int length = 1;
                while (numSet.contains(num + length)) {
                    length++;
                }
                longest = Integer.max(longest, length);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int[] ex1 = {0, 0, 1, 3};
        System.out.println("Example 1: " + solution.longestConsecutive(ex1));
    }
}

