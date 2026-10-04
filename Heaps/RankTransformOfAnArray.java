//problem link : https://leetcode.com/problems/rank-transform-of-an-array/description/
//problem name : Rank Transform of an Array

//Solution with time complexity O(n log n) and space complexity is O(n).

package Heaps;
import java.util.*;

class Solution {
    public int[] arrayRankTransform(int[] arr) {

       int n = arr.length;
       PriorityQueue<Integer> minHeap = new PriorityQueue<>();

       for(int i=0 ; i<n ; i++){
        minHeap.add(arr[i]);
       } 

       HashMap<Integer , Integer> map = new HashMap<>();

       Integer prev = null;
       int rank = 1;

       while(!minHeap.isEmpty()){
        int curr = minHeap.poll();

        if(prev == null || curr != prev){
            map.put(curr , rank);
            rank++;
        }
        prev = curr;
       }
       for(int i=0 ; i<n ; i++){
        arr[i] = map.get(arr[i]);
       }
       return arr;
    }
}