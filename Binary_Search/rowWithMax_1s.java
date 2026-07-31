//brute force solution with time complexity O(n*m) and space complexity O(1).
/*class Solution {
    public int rowWithMax1s(int[][] mat) {
       int n = mat.length;
       int m = mat[0].length;

       int maxCount = 0;
       int rowIndex = -1;
       for(int i=0; i<n; i++){
          int count = 0;
          for(int j=0; j<m; j++){
            if(mat[i][j]==1){
                count++;
            }
          }

          if(count>maxCount){
            maxCount = count;
            rowIndex = i;
          }
       }
       return rowIndex;
    }
}*/

//better solution by using binary search on each rows with time complexity = O(n log m)
/*
class Solution {
    public int rowWithMax1s(int[][] mat) {
       int n = mat.length;
       int m = mat[0].length;

       int maxRow = -1;
       int maxOnes = 0;

       for(int i=0; i<n; i++){
        int low = 0, high = m-1;
        int firstOne = m;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(mat[i][mid]==1){
                firstOne = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        int ones = m - firstOne;
        if(ones > maxOnes){
            maxOnes = ones;
            maxRow = i;
        }
       }
       return maxRow;
    }
}
 */

//optimal solution with time complexity = O(n+m).

package Binary_Search;

class Solution {
    public int rowWithMax1s(int[][] mat) {
       int n = mat.length;
       int m = mat[0].length;
       int rowIndex = -1;
       int j = m-1;

       for(int i=0; i<n; i++){
        while(j>=0 && mat[i][j]==1){
            rowIndex = i;
            j--;
        }
       }
       return rowIndex;
    }
}