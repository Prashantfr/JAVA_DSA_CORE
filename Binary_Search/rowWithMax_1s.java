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

package Binary_Search;