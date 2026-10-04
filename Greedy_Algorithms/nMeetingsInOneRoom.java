//problem link : https://takeuforward.org/practice/dsa/n-meetings-in-one-room
//problem name : N meetings in one room

//Solution with time complexity of O(n log n) and space complexity is O(n).

package Greedy_Algorithms;
import java.util.*;

class Solution {
    public int maxMeetings(int[] start, int[] end) {
        int[][] meetings = new int[start.length][2];
        for(int i=0 ; i<start.length ; i++){
            meetings[i][0] = start[i];
            meetings[i][1] =end[i];
        }

        Arrays.sort(meetings , (a,b) -> Integer.compare(a[1], b[1]));

        int meet = 1;
        int prevEnd = meetings[0][1];
       for(int i=0 ; i<start.length ; i++){
        if(meetings[i][0] > prevEnd){
            meet++;
            prevEnd = meetings[i][1];
        }
       }
       return meet;
    }
}
