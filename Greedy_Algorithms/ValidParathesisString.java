//problem link : https://leetcode.com/problems/valid-parenthesis-string/description/
//problem name : Valid Parenthesis String

//Solution with time complexity of O(n) and space complexity is O(1).

package Greedy_Algorithms;

class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;
        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                minOpen++;
                maxOpen++;
            }
            else if(ch == ')'){
                minOpen--;
                maxOpen--;
            }
            else{
                minOpen--;
                maxOpen++;
            }
            if(maxOpen < 0) return false;

            if(minOpen < 0) minOpen = 0;
        }
        return minOpen == 0;
    }
}
