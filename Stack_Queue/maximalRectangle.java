//problem link : https://leetcode.com/problems/maximal-rectangle/description/
//problem name : Maximal Rectangle

//brute force solution with time complexity of O(n³) and space complexity O(m).

package Stack_Queue;

class Solution {
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
}
