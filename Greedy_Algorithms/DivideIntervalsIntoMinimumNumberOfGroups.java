//problem link : https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/description/
//problem name : Divide Intervals Into Minimum Number of Groups

//Solution with time complexity of O(n log n) and space complexity is O(n).

package Greedy_Algorithms;
import java.util.*;

class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for(int i=0 ; i<n ; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int i=0; 
        int j=0;
        int groups = 0;
        int maxGroup = 0;
        while(i<n){
            if(start[i] <= end[j]){
                groups++;
                maxGroup = Math.max(maxGroup , groups);
                i++;
            }
            else{
                groups--;
                j++;
            }
        }
        return maxGroup;
    }
}
