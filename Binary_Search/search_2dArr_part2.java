//brute force with time complexity => O(n*m) and space complexity => O(1).

//optimal soslution with time complexity => O(n+m) and space complexity => O(1). 

//brute force
/*
public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        for(int i=0 ; i<n; i++){
            for(int j=0; j<m; j++){
                if(target==matrix[i][j]) return true;
            }
        }
        return false;
    }
*/

//optimal solution

package Binary_Search;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int row = 0;
        int col = m-1;

        while(row<n && col>=0){
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target) col--;
            else row++;
        }
        return false;
    }
}
