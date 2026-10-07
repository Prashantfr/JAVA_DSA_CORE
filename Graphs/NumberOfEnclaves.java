//problem link : https://leetcode.com/problems/number-of-enclaves/description/
//problem name : Number of Enclaves.

//Solution with time complexity of O(n × m) and space complexity O(n × m).

package Graphs;

class Solution {

    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};

    public int numEnclaves(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        for(int j=0 ; j<m ; j++){
            if(grid[0][j] == 1){
                dfs(grid , 0 , j);
            }
            if(grid[n-1][j] == 1){
                dfs(grid , n-1 , j);
            }
        }

        for(int i=0 ; i<n ; i++){
            if(grid[i][0] == 1){
                dfs(grid , i , 0);
            }
            if(grid[i][m-1] == 1){
                dfs(grid , i , m-1);
            }
        }

        int count = 0;

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int[][] grid , int row , int col){
        int n = grid.length;
        int m = grid[0].length;

        if(row < 0 || row >= n || col < 0 || col >=m){
            return;
        }

        if(grid[row][col] == 0){
            return;
        }

        grid[row][col] = 0;

        for(int i=0 ; i<4 ; i++){
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            dfs(grid , newRow , newCol);
        }
    }
}
