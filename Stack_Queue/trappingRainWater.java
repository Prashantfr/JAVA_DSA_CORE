//problem link : https://leetcode.com/problems/trapping-rain-water/description/
//problem name : Trapping Rainwater

//brute force solution with time complexity of O(n²) and space complexity O(1).
package Stack_Queue;
/*class Solution {
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
}*/

//better solution with time complexity of O(n) and space complexity O(n) using prefix and suffix.
/*class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        for(int i=1; i<n; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        rightMax[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int water = 0;
        for(int i=0; i<n; i++){
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return water;
    }
}*/

//optimal solution with time complexity of O(n) and space complexity O(1).
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = height.length-1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while(left<right){
            if(height[left] <= height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];
                }
                else{
                    water += leftMax - height[left];
                }
                left++;
            }

            else{
                if(height[right] >= rightMax){
                    rightMax = height[right];
                }
                else{
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }
}
