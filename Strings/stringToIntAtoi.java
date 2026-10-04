//problem name : String to Integer
//problem link : https://leetcode.com/problems/string-to-integer-atoi/description/

//brute force solution with time complexity of O(n) and space complexity O(1).


package Strings;

class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();

        while(i<n && s.charAt(i) == ' ') i++;

        int sign = 1;
        if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            if(s.charAt(i) == '-') sign = -1;
            i++;
        }

        int result = 0;

        while(i<n && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';

            if(result > (Integer.MAX_VALUE - digit) / 10){
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }
        return result*sign;
    }
}
