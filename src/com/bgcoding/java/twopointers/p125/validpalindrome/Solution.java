package com.bgcoding.java.twopointers.p125.validpalindrome;

// 1st attempt
// Time: O(n)
// Space: O(n)
class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }

        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            char currStart = s.charAt(start);
            char currEnd = s.charAt(end);

            if (!Character.isLetterOrDigit(currStart)) {
                start++;
            } else if (!Character.isLetterOrDigit(currEnd)) {
                end--;
            } else {
                // letter or digit
                // convert to lowercase start and end characters
                currStart = Character.toLowerCase(currStart);
                currEnd = Character.toLowerCase(currEnd);

                if (currStart != currEnd) return false;

                start++;
                end--;
            }
        }

        return true;
    }
}