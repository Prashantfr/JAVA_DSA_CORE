//problem name : Maximum Nesting Depth of the Parentheses
//problem link : https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/

//brute force solution with time complexity of O(n^2) and space complexity O(1).


package Strings;
/*class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        int maxDepth = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                int depth = 1;
                int current = 1;

                for (int j = i + 1; j < n; j++) {
                    if (s.charAt(j) == '(') {
                        current++;
                        depth = Math.max(depth, current);
                    } else if (s.charAt(j) == ')') {
                        current--;
                        if (current == 0) break;
                    }
                }

                maxDepth = Math.max(maxDepth, depth);
            }
        }

        return maxDepth;
    }
}*/

//optimal solution with time complexity of O(n) and space complexity O(1).

class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        int maxDepth = 0;
        int current = 0;

        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if( c == '('){
                current++;
                maxDepth = Math.max(current, maxDepth);
            }
            else if(c == ')'){
                current--;
            }
        }
        return maxDepth;
    }
}