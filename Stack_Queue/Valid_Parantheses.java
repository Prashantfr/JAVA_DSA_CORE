//problem link : https://leetcode.com/problems/valid-parentheses/
//problem name : Valid Parantheses

//solution with time complexity of O(n) and space complexity O(n).

package Stack_Queue;

import java.util.Stack;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            }
            else{
                if(st.isEmpty()) return false;
                char top = st.pop();

                if((ch == ')' && top!='(') ||
                (ch == ']' && top!='[') ||
                (ch == '}' && top!= '{')){
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
