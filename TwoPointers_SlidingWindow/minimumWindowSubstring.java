//problem name : Minimum Window Substring
//problem link : https://leetcode.com/problems/minimum-window-substring/description/

//brute force solution with time complexity of O(n^2.k) and space complexity O(1).
package TwoPointers_SlidingWindow;
import java.util.HashMap;
/*class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for(int i=0; i<m; i++){
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c,0)+1);
        }

        int minLen = Integer.MAX_VALUE;
        String ans = "";

        for(int i=0; i<n; i++){
            HashMap<Character, Integer> windowMap = new HashMap<>();
            for(int j=i; j<n; j++){
                char ch = s.charAt(j);
                windowMap.put(ch, windowMap.getOrDefault(ch,0)+1);

                if(isValid(windowMap, tMap)){
                    if(j-i+1 < minLen){
                        minLen = j-i+1;
                        ans = s.substring(i, j+1);
                    }
                    break;
                }
            }
        }
        return ans;
    }

    private boolean isValid( HashMap<Character, Integer> windowMap , HashMap<Character, Integer> tMap){
        for(char key: tMap.keySet()){
            if (windowMap.getOrDefault(key,0) < tMap.get(key)){
                return false;
            }
        }
        return true;
    }
}*/

//optimal solution with time complexity of O(n) and space complexity O(1).
class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<m; i++){
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int left = 0 , right = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < n){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                if(map.get(ch)>0){
                    count ++;
                }
                map.put(ch, map.get(ch)-1);
            }

            while (count == t.length()){
                if(right-left+1 < minLen){
                    minLen = right-left+1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                if(map.containsKey(leftChar)){
                    map.put(leftChar, map.get(leftChar)+1);

                    if(map.get(leftChar)>0){
                        count--;
                    }
                }
                left++;
            }
            right++;
        }
        if(minLen == Integer.MAX_VALUE)
         return "";
        else{
           return s.substring(start, start+minLen);
        }
    }
}