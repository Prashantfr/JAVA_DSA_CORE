//problem link : https://leetcode.com/problems/maximal-rectangle/description/
//problem name : Maximal Rectangle

//brute force solution with time complexity of O(n³) and space complexity O(m).

package Stack_Queue;

/*class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int[] height = new int[m];

            for (int j = i; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    height[k] = (matrix[j][k] == '1') ? height[k] + 1 : 0;
                }

                // brute histogram (O(m^2))
                for (int x = 0; x < m; x++) {
                    int minHeight = height[x];
                    for (int y = x; y < m; y++) {
                        minHeight = Math.min(minHeight, height[y]);
                        maxArea = Math.max(maxArea, minHeight * (y - x + 1));
                    }
                }
            }
        }

        return maxArea;
    }
}*/

//optimal solution with time complexity of O(nxm) and space complexity O(m).
import java.util.*;
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] height = new int[m];
        int maxArea = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                height[j] = (matrix[i][j] == '1') ? height[j]+1 : 0;
            }
            maxArea = Math.max(maxArea, largestRectangle(height));
        }
        return maxArea;
    }

    private int largestRectangle(int[] arr){
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            left[i] = st.isEmpty() ? (i+1) : (i - st.peek());
            st.push(i);
        }

        st.clear();

        for(int i = n-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            right[i] = st.isEmpty() ? (n-i) : (st.peek() - i);
            st.push(i);
        }

        int maxArea = 0;
        for(int i=0; i<n; i++){
            int width = left[i] + right[i] - 1;
            int area = arr[i]*width;
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
