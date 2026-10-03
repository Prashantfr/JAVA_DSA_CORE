//problem link : https://leetcode.com/problems/top-k-frequent-elements/description/
//problem name : Top K Frequent Elements

//Solution with time complexity of O(n log k) and space complexity is O(n).

package Heaps;
import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int i=0 ; i<nums.length ; i++){
            map.put(nums[i] , map.getOrDefault(nums[i] , 0) +1);
        }
        
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        for(int key : map.keySet()){
            int freq = map.get(key);
            heap.add(new int[]{key , freq});
            if(heap.size() > k){
                heap.poll();
            }
        }

        int[] result = new int[k];
        int index = 0;
        while(!heap.isEmpty()){
            result[index] = heap.poll()[0];
            index++;
        }
        return result;
    }
}
