//problem link : https://leetcode.com/problems/largest-rectangle-in-histogram/description/
//problem name : Largest Rectangle in Histogram

//brute force solution with time complexity of O(N²) and space complexity O(1).
//The next and previous smaller element's indices are just walls , we should avoid them while calculating the area.


package Stack_Queue;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        for(int i=0; i<n; i++){
            int left = i;
            int right = i;

        while(left>=0 && heights[left] >= heights[i]){
            left--;
        }

        while(right<n && heights[right] >= heights[i]){
            right++;
        }

        int width = right-left-1;
        int area = heights[i]*width;
        maxArea = Math.max(maxArea, area);
        }
    return maxArea;
  }
}
