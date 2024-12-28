package com.bgcoding.java.arraysandhashing.p347.topkfrequentelements;

import java.util.*;

// Sorting approach
class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Place in map, <num, freq>
        Map<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        // 2. Place in heap
        // 3. Sort by freq, ascending
        // 4. Remove the least frequent by polling
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = Objects.requireNonNull(heap.poll())[1];
        }

        return res;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

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

