//problem link => https://leetcode.com/problems/longest-substring-without-repeating-characters/

//brute force with time complexity => O(N²) and space complexity => O(1).
/*class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;

        for(int i=0; i<n; i++){
            boolean[] visited = new boolean[256];
            for(int j=i; j<n; j++){
                char ch = s.charAt(j);
                if(visited[ch]){
                    break;
                }
                visited[ch] = true;
                int len = j-i+1;
                maxLen = Math.max(maxLen,len);
            }
        }
        return maxLen;
    }
}*/


//optimal solution with a time complexity => O(N) and space complexity => O(1).
package TwoPointers_SlidingWindow;
import java.util.Map;
import java.util.HashMap;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map< Character , Integer > lastSeen = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        for(int right=left; right<n; right++){
            char ch = s.charAt(right);
            if(lastSeen.containsKey(ch) && lastSeen.get(ch)>=left){
                left = lastSeen.get(ch)+1;
            }
            lastSeen.put(ch,right);
            int len = right-left+1;
            maxLen = Math.max(len,maxLen);
        }
        return maxLen;
    }
}