package com.bgcoding.java.p347.topkfrequentelements;

import java.util.*;

// Sorting approach
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // 1. Place in map, <num, freq>
        Map<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        // 2. Place in array list
        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            // freq, num
            list.add(new int[] {entry.getValue(), entry.getKey()});
        }

        // 3. Sort higher freq, descending
        // positive difference means do this ordering -> b, a
        list.sort((a, b) -> b[0] - a[0]);

        // 4. Add to result set
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i)[1];
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        int[] result1 = solution.topKFrequent(nums1, k1);
        System.out.println("Example 1 Output: " + Arrays.toString(result1)); // Output: [1, 2]

        // Example 2
        int[] nums2 = {1};
        int k2 = 1;
        int[] result2 = solution.topKFrequent(nums2, k2);
        System.out.println("Example 2 Output: " + Arrays.toString(result2)); // Output: [1]
    }
}
