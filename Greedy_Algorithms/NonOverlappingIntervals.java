//problem link : https://leetcode.com/problems/non-overlapping-intervals/description/
//problem name : Non-overlapping Intervals

//Solution with time complexity of O(n log n) and space complexity is O(1).

package Greedy_Algorithms;
import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals , (a,b) -> a[1]-b[1]);
        int count = 0;
        int prevEnd = Integer.MIN_VALUE;

        for(int i=0 ; i<intervals.length ; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(start >= prevEnd){
                prevEnd = end;
            }
            else{
                count++;
            }
        }
        return count;
    }
}
