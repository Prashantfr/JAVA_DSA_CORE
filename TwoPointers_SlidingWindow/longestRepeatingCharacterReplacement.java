//problem name :  Longest Repeating Character Replacement
//problem link : https://leetcode.com/problems/longest-repeating-character-replacement/description/


//brute force with time complexity => O(N²) and space complexity => O(1).
package TwoPointers_SlidingWindow;
import java.util.HashMap;
/*class Solution {
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
}*/

//optimal solution with time complexity => O(N) and space complexity => O(1).
class Solution {
    public int characterReplacement(String s, int k) {
        HashMap <Character, Integer> map = new HashMap<>();
        int n = s.length();
        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;
        for(int right=0; right<n; right++){
            char ch = s.charAt(right);

            map.put(ch, map.getOrDefault(ch,0)+1);

            maxFreq = Math.max(maxFreq, map.get(ch));

            while( (right-left+1) - maxFreq > k){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar)-1);
                left++;
            } 
            maxLen = Math.max(maxLen, (right-left+1));      
        }
        return maxLen;
    }
}