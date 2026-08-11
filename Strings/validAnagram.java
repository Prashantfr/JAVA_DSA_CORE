//problem name : Largest Odd Number in String
//problem link : https://leetcode.com/problems/largest-odd-number-in-string/description/

//brute force solution with time complexity of O(nlogn) and space complexity O(n).

package Strings;
import java.util.Arrays;
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a,b);
    }
}
