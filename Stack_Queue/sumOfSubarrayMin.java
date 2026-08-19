//problem link : https://leetcode.com/problems/sum-of-subarray-minimums/description/
//problem name : Sum of Subarray Minimums

//brute force solution with time complexity of O(n^2) and space complexity O(1).

package Stack_Queue;

class Solution {
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
}
