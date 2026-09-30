//problem link : https://takeuforward.org/practice/dsa/shortest-job-first
//problem name : Shortest Job First

//Solution with time complexity of O(nlogn) and space complexity is O(1). 

package Greedy_Algorithms;
import java.util.*;

class Solution {
    public long solve(int[] bt) {
        Arrays.sort(bt);

        long totalWaitTime = 0;
        long currentWaitTime = 0;

        for(int i=0 ; i<bt.length ; i++){
            totalWaitTime += currentWaitTime;
            currentWaitTime += bt[i];
        }
        return totalWaitTime / bt.length;
    }
}
