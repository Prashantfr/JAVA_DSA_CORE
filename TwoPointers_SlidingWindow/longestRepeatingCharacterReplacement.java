//problem name :  Longest Repeating Character Replacement
//problem link : https://leetcode.com/problems/longest-repeating-character-replacement/description/


//brute force with time complexity => O(N²) and space complexity => O(1).
package TwoPointers_SlidingWindow;
import java.util.HashMap;
class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxLen = 0;
        for(int i=0; i<n; i++){
            HashMap <Character, Integer> map = new HashMap<>();
            int maxFreq = 0;
            for(int j=i; j<n; j++){
                char ch = s.charAt(j);

                map.put(ch, map.getOrDefault(ch,0)+1);

                maxFreq = Math.max(maxFreq, map.get(ch));

                int windowSize = j-i+1;

                if(windowSize - maxFreq <= k){
                    maxLen = Math.max(maxLen, windowSize);
                }
            }
       }
       return maxLen;
    }
}