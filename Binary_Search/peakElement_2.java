//Link : https://leetcode.com/problems/find-a-peak-element-ii/description/.
//Problem : find the peak element 2.

//brute force                    
//time complexity => O(n × m)
//space complexity => O(1)

//brute force solution
/*
 public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                int up = (i>0) ? mat[i-1][j] : -1;
                int down = (i>n-1) ? mat[i+1][j] : -1;
                int left = (j>0) ? mat[i][j-1] : -1;
                int right = (j<n-1) ? mat[i][j+1] : -1;

                if(mat[i][j]>left 
                && mat[i][j]>right
                && mat[i][j]>up
                && mat[i][j]>down){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
 */

//optimal solution
//time complexity => O(n log m)
//space complexity => O(1)

package Binary_Search;
class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0 , high = m-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;

            int maxRow = 0;
            for(int i=0; i<n; i++){
                if(mat[i][mid]>mat[maxRow][mid]){
                    maxRow = i;
                }
            }

            int left = (mid-1 >= 0) ? mat[maxRow][mid-1] : -1;
            int right = (mid+1 < m) ? mat[maxRow][mid+1] : -1;

            if(mat[maxRow][mid] > left && mat[maxRow][mid] > right){
                return new int[]{maxRow,mid};
            }
            else if( left > mat[maxRow][mid] ){
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return new int[]{-1,-1};
    }
}


