package com.bgcoding.java.arraysandhashing.p271.encodeanddecodestrings;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String str : strs)
            // "{length}#{word}..."
            res.append(str.length()).append('#').append(str);
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;                                                      // i is used as the start idx
        while (i < str.length()) {
            int j = i;                                                  // j is used as the end idx
            while (str.charAt(j) != '#') {                              // iterate until a '#' is parsed, it is possible for the length to be in tens, hundreds, etc
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));         // parse the length here
            i = j + 1;                                                  // start idx is the substring after '#'
            j = i + length;                                             // end idx is start idx + length
            res.add(str.substring(i, j));                               // get the actual word here
            i = j;                                                      // adjust start index to be after the previously parsed word
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] ex1 = {"neet","code","love","you"};
        String encoded = solution.encode(List.of(ex1));
        System.out.println("Example 1 Encoded: " + encoded);
        List<String> decoded = solution.decode(encoded);
        System.out.println("Example 1 Decoded: " + decoded);
    }

}
