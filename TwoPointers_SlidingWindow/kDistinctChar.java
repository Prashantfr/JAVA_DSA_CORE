//problem link : https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/
//problem name : Longest Substring With At Most K Distinct Characters
//brute force solution with time complexity of O(n^2) and space complexity O(1).

package TwoPointers_SlidingWindow;
/*import java.util.HashSet;
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
}*/


//optimal solution with time complexity of O(n) and space complexity O(1) using a hashmap.

import java.util.HashMap;
class Solution {
    public int kDistinctChar(String s, int k) {
        int n = s.length();
        int left = 0;
        int maxLen = 0;
        HashMap <Character, Integer> map = new HashMap<>();
        for(int right=0; right<n; right++){
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while(map.size()>k){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar)-1);

                if(map.get(leftChar)==0){
                    map.remove(leftChar);
                }
                left++;
            }
            int len = right-left+1;
            maxLen = Math.max(len, maxLen);
        }
        return maxLen;
    }
}