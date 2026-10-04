//problem link : https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
//problem name : Kth Largest Element in a Stream

//Solution with time complexity of comstructor -> O(n log k) and add() method -> O(log k) and space complexity is O(k).

package Heaps;
import java.util.*;

class KthLargest {

    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;

        for(int i=0 ; i<nums.length ; i++){
            minHeap.add(nums[i]);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {

        minHeap.add(val);

        if(minHeap.size() > k){
            minHeap.poll(); 
        }
        return minHeap.peek();
    }
}
