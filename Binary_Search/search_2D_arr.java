//brute force with time complexity => O(n*m) and space complexity => O(1).
/*
public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    } */


//better solution with time complexity => O(n log m) and space complexity => O(1).
/*
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0; i<matrix.length; i++){
            if(target >= matrix[i][0] && target <= matrix[i][matrix[0].length-1]){
                int low = 0 , high = matrix[0].length-1;
                int mid = low + (high-low)/2;
                while(low<=high){
                    if(mid==target){
                        return true;
                    }
                    else if(mid>target){
                        high = mid-1;
                    }
                    else {
                        low = mid+1;
                    }
                }
            }
        }
        return false;
    }
}
*/        

//optimal soslution with time complexity => O(log(n*m)) and space complexity => O(1).        

package Binary_Search;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0, high = (n*m)-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int row = mid/m;
            int col = mid%m;

            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target) low = mid+1;
            else high = mid-1;
        }
        return false;
    }
}
