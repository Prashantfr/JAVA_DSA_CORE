//problem link : https://leetcode.com/problems/largest-rectangle-in-histogram/description/
//problem name : Largest Rectangle in Histogram

//brute force solution with time complexity of O(N²) and space complexity O(1).
//The next and previous smaller element's indices are just walls , we should avoid them while calculating the area.


package Stack_Queue;

/*class Solution {
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
}*/

//optimal solution with time complexity of O(n) and space complexity O(n).
import java.util.*;
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<n; i++){
        while(!st.isEmpty() &&  heights[st.peek()] >= heights[i]){
            st.pop();
        }
        left[i] = st.isEmpty() ? (i + 1) : (i - st.peek());
        st.push(i);
        }
        st.clear();

        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                st.pop();
            }
            right[i] = st.isEmpty() ? (n - i) : (st.peek() - i);
            st.push(i);
        }

        int maxArea = 0;
        for(int i=0; i<n; i++){
            int width = right[i] + left[i] - 1;
            int area = heights[i]*width;
            maxArea = Math.max(maxArea , area);
        }
        return maxArea;
    }

}