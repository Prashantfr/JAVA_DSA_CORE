//problem link : https://leetcode.com/problems/sum-of-subarray-ranges/description/
//problem name : Sum of Subarray Ranges

//brute force solution with time complexity of O(n^2) and space complexity O(1).


package Stack_Queue;

/*class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long sum = 0;

        for(int i=0; i<n; i++){
            int min = nums[i];
            int max = nums[i];

            for(int j=i; j<n; j++){
                min = Math.min( min , nums[j] );
                max = Math.max( max , nums[j] );

                sum += (max - min);
            }
        }
        return sum;
    }
}*/

//optimal solution with time complexity of O(n) and space complexity O(n).
import java.util.*;
class Solution {
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMax(nums) - sumSubarrayMin(nums);
    }

    private long sumSubarrayMin(int[] nums){
        int n = nums.length;
        long sum = 0;

        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && nums[st.peek()] > nums[i]){
                st.pop();
            }
            left[i] = st.isEmpty() ? (i+1) : (i - st.peek());
            st.push(i);
        }

        st.clear();

        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                st.pop();
            }
            right[i] = st.isEmpty() ? (n-i) : (st.peek() - i);
            st.push(i);
        }

        for(int i=0; i<n; i++){
            sum += (long) nums[i] * left[i] * right[i];
        }
        return sum;
    } 

    private long sumSubarrayMax(int[] nums){
        int n = nums.length;
        long sum = 0;

        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i]){
                st.pop();
            }
            left[i] = st.isEmpty() ? (i+1) : (i - st.peek());
            st.push(i);
        }

        st.clear();

        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]){
                st.pop();
            }
            right[i] = st.isEmpty() ? (n-i) : (st.peek() - i);
            st.push(i);
        }

        for(int i=0; i<n; i++){
            sum += (long) nums[i] * left[i] * right[i];
        }
        return sum;
    }
}
