//problem name : Remove Outermost Parentheses
//problem link : https://leetcode.com/problems/remove-outermost-parentheses/description/

//brute force solution with time complexity of O(n^2)(substring creation) and space complexity O(n).
package Strings;

class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int balance = 0;
        int start = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') balance++;
            else balance--;

            if(balance == 0){
                result.append(s.substring(start+1, i));
                start = i=1;
            }
        }
        return result.toString();
    }
}