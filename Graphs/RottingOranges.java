//problem link : https://leetcode.com/problems/rotting-oranges/description/
//problem name : Rotting Oranges.

//Solution with time complexity of O(n × m) and space complexity O(n × m).

package Graphs;
import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        int minutes = 0;

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        while(!q.isEmpty() && fresh > 0){
            int size = q.size();

            for(int i=0 ; i<size ; i++){
                int[] current = q.poll();

                int row = current[0];
                int col = current[1];

                for(int k=0 ; k<4 ; k++){

                    int newRow = row + dr[k];
                    int newCol = col + dc[k];

                    if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1){
                        
                        grid[newRow][newCol] = 2;

                        fresh--;

                        q.add(new int[]{newRow , newCol});
                    }
                }
            }
            minutes++;
        }
        if(fresh == 0){
            return minutes;
        }
        else{
            return -1;
        }
    }
}
