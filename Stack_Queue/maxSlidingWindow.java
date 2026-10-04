//problem link : https://leetcode.com/problems/sliding-window-maximum/
//problem name : Sliding window maximum.

//brute force solution with time complexity of O(n * k) and space complexity O(1)(ignoring output).

package Stack_Queue;

/*class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];

        for(int i=0; i<=n-k ; i++){
            int max = nums[i];

            for(int j=i; j<i+k; j++){
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }
        return res;
    }
}*/

//optimal solution with time complexity of O(n) and space complexity O(k).
import java.util.*;
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=0; i<n; i++){

            if(!dq.isEmpty() && dq.peekFirst() == i-k){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i>=k-1){
                res[i-k+1] = nums[dq.peekFirst()];
            }
        }
        return res;
   }
}
