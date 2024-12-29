package com.bgcoding.java.twopointers.p15.threesum;

import java.util.*;

// 1st attempt
// Sorting + Two Pointers
// Time: O(n^2)
// Space: O(1) excl. result

/*
* Rationale
* Sorting ->        To skip duplicates easily
* Two Pointers ->   To change the values of the j, k pairs, while i is fixed
* */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        final int n = nums.length - 1;
        Arrays.sort(nums);                              // sort to identify duplicates

        for (int i = 0; i < n; i++) {
            // skip duplicates here
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // get the j, k pairs after i
            int left = i + 1;
            int right = n;

            while (left < right) {                      // we use < because i, j, and k should be distinct
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // skip duplicates
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }

            }
        }

        return res;
    }
}