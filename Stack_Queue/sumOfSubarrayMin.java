//problem link : https://leetcode.com/problems/sum-of-subarray-minimums/description/
//problem name : Sum of Subarray Minimums

//brute force solution with time complexity of O(n^2) and space complexity O(1).

package Stack_Queue;

/*class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long sum = 0;
        int MOD = 1000000000 + 7;

        for(int i=0; i<n; i++){
            int min = arr[i];
            for(int j=i; j<n; j++){
                min = Math.min(min,arr[j]);
                sum += min;
                sum %= MOD;
            }
        }
        return (int) sum;
    }
}*/

//optimal solution with time complexity of O(n) and space complexity O(n).
import java.util.Stack;
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = 1000000000 + 7;

        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            left[i] = st.isEmpty() ? (i+1) : (i - st.peek());
            st.push(i);
        }
        st.clear();

        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            right[i] = st.isEmpty() ? (n-i) : (st.peek() - i);
            st.push(i);
        }

        long sum = 0;
        for(int i=0; i<n; i++){
            long contribution = (long) arr[i] * left[i] * right[i];
            sum = (sum + contribution) % MOD;
        }
        return (int) sum;
    }
}