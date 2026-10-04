//problem name : Valid anagram.
//problem link : https://leetcode.com/problems/valid-anagram/

//brute force solution with time complexity of O(nlogn) and space complexity O(n).

package Strings;
/*import java.util.Arrays;
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
*/

//optimal solution with time complexity of O(n) and space complexity O(1).
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] freq = new int[26];

        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for(int i=0; i<freq.length; i++){
            if(freq[i] != 0) return false;
        }
        return true;
    }
}