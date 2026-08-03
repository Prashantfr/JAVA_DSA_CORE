//problem link : https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/
//problem name : Longest Substring With At Most K Distinct Characters
//brute force solution with time complexity of O(n^2) and space complexity O(1).

package TwoPointers_SlidingWindow;
import java.util.HashSet;
class Solution {
    public int kDistinctChar(String s, int k) {
        int n = s.length();
        int maxLen = 0;
        for(int i=0; i<n; i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=i; j<n; j++){
                set.add(s.charAt(j));

                if(set.size()<=k){
                    int len = j-i+1;
                    maxLen = Math.max(len,maxLen);
                }
                else{
                    break;
                }
            }
        }
        return maxLen;
    }
}
