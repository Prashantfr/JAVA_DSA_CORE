//problem name : Number of Substrings Containing All Three Characters
//problem link : https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/

//brute force solution with time complexity of O(n^2) and space complexity O(1).
package TwoPointers_SlidingWindow;
import java.util.HashSet;
class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for(int i=0; i<n; i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=i; j<n; j++){
                set.add(s.charAt(j));
                if(set.size()==3){
                    count += (n-j);
                    break;
                }
            }
        }
        return count;
    }
}