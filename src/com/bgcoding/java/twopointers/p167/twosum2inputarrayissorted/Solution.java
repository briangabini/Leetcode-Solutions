package com.bgcoding.java.twopointers.p167.twosum2inputarrayissorted;

// 1st attempt
// Using Two Pointers
// Time: O(n)
// Space: O(1)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int start = 0;
        int end = numbers.length -1;

        while (start <= end) {
            int sum = numbers[start] + numbers[end];

            if (sum < target) {
                start++;
            } else if (sum > target) {
                end--;
            } else {
                res[0] = start + 1;
                res[1] = end + 1;
                break;
            }
        }

        return res;
    }
}
