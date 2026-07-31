//problem link => https://leetcode.com/problems/longest-substring-without-repeating-characters/
//brute force with time complexity => O(N²)
package TwoPointers_SlidingWindow;

class Solution {
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
}
