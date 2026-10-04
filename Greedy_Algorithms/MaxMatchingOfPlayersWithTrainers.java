//problem link : https://leetcode.com/problems/maximum-matching-of-players-with-trainers/description/
//problem name : Maximum Matching of Players With Trainers

//Solution with time complexity of O(n log n) and space complexity is O(1).

package Greedy_Algorithms;
import java.util.*;

class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int i = 0;
        int j = 0;

        while(i < players.length && j < trainers.length){
            if(players[i] <= trainers[j]){
                i++;
            }
            j++;
        }
        return i;
    }
}
