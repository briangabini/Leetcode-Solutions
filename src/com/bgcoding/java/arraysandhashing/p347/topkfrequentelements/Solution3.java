package com.bgcoding.java.arraysandhashing.p347.topkfrequentelements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Bucket sort approach
// Time complexity: O(n)
// Space complexity: O(n)
public class Solution3 {

    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];     // create a bucket array of List<Integer> of size nums.length + 1
        Map<Integer, Integer> count = new HashMap<>();

        // 1. Place in map, <num, freq>
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // 2. Place in bucket
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int frequency = entry.getValue();
            int num = entry.getKey();

            // initialize the array list
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }

            // freq, num
            bucket[frequency].add(num);
        }


        List<Integer> res = new ArrayList<>();

        // 3. Iterate through the bucket array from the end
        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
