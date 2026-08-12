//problem name : Isomorphic strings
//problem link : https://leetcode.com/problems/isomorphic-strings/description/

//brute force solution with time complexity of O(n^2) and space complexity O(1).

package Strings;
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // Check forward mapping
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == c1 && t.charAt(j) != c2)
                    return false;

                if (t.charAt(j) == c2 && s.charAt(j) != c1)
                    return false;
            }
        }
        return true;
    }
}
