//problem link : https://leetcode.com/problems/trapping-rain-water/description/
//problem name : Trapping Rainwater

//brute force solution with time complexity of O(n²) and space complexity O(1).

package Stack_Queue;

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int water = 0;
        for(int i=0; i<n; i++){
            int leftMax = 0;
            int rightMax = 0;

            for(int j=0; j<i; j++){
                leftMax = Math.max(leftMax, height[j]);
            }
            for(int j=i; j<n; j++){
                rightMax = Math.max(rightMax, height[j]);
            }

            water += Math.min(leftMax, rightMax) - height[i];
        }
        return water;
    }
}
