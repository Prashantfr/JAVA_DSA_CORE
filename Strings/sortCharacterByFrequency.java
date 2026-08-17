//problem name : Sort Characters By Frequency
//problem link : https://leetcode.com/problems/sort-characters-by-frequency/description/

//time complexity of O(n + k log k) and space complexity O(n).
package Strings;
import java.util.*;
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        List<Character> list = new ArrayList<>(map.keySet());

        Collections.sort(list, (a,b) -> map.get(b) - map.get(a));

        StringBuilder sb = new StringBuilder();
        
        for(int j=0; j<list.size(); j++){
            char c = list.get(j);
            int freq = map.get(c);
            for(int i=0; i<freq; i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

