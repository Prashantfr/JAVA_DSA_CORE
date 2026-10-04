//problem name : Roman to Integer
//problem link : https://leetcode.com/problems/roman-to-integer/description/

//solution with time complexity of O(n) and space complexity O(1).


package Strings;
import java.util.HashMap;
class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int total = 0;
        int n = s.length();
        for(int i=0; i<n; i++){
            int curr = map.get(s.charAt(i));
            if(i+1<n && curr<map.get(s.charAt(i+1))){
                total -= curr;
            }
            else {
                total += curr;
            }
        }
        return total;
    }
}
