//problem name : Number of Substrings Containing All Three Characters
//problem link : https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/

//brute force solution with time complexity of O(n^2) and space complexity O(1).
package TwoPointers_SlidingWindow;
/*import java.util.HashSet;
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
}*/

//optimal solution with a time complexity => O(N) and space complexity => O(1).
import java.util.HashMap;
class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int left = 0;
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int right=0; right<n; right++){
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch,0)+1);

            while(map.size()==3){
                count += (n-right);

                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar)-1);

                if(map.get(leftChar)==0){
                    map.remove(leftChar);
                }
                left++;
            }
        }
        return count;
    }
}