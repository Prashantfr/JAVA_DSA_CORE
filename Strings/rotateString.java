//problem link : https://leetcode.com/problems/rotate-string/description/
//problem name : Rotate String
//solution with time complexity of O(n) and space complexity O(n)(for concatenate string).

package Strings;

class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;

        String combined = s + s;
        return combined.contains(goal);
    }
}