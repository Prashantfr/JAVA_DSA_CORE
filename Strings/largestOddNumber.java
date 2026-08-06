//problem name : Largest Odd Number in String
//problem link : https://leetcode.com/problems/largest-odd-number-in-string/description/

//brute force solution with time complexity of O(n^3) and space complexity O(n).
package Strings;
import java.util.Arrays;
class Solution {
    public String largestOddNumber(String num) {
        int n = nums.length();
        String result = "";
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                String sub = num.subString(i, j+1);
                char last = sub.charAt(sub.length()-1);
                if((last-'0')%2 == 1){
                    if(sub.length()>result.length()){
                        result = sub;
                    }
                }
            }
        }
        return result;
    }
}