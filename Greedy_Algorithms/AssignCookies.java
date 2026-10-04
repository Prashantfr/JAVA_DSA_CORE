//problem link : https://leetcode.com/problems/assign-cookies/description/
//problem name : Assign Cookies

//Solution with time complexity of O(n log n) and space complexity is O(1).

package Greedy_Algorithms;
import java.util.*;

class Solution {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;

        while(i < g.length && j < s.length){
                if(s[j] >= g[i]){
                    i++;
                }
               j++;
            }
        return i;
    }
}
