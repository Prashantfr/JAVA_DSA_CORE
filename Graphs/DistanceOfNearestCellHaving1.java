//problem link : https://leetcode.com/problems/01-matrix/description/
//problem name : Distance of nearest cell having one.

//Solution with time complexity of O(n × m) and space complexity O(n × m).

package Graphs;
import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();

        int n = mat.length;
        int m = mat[0].length;

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j});
                }
                else{
                    mat[i][j] = -1;
                }
            }
        }
        int[] dr = {-1 , 1 , 0 , 0};
        int[] dc = {0 , 0 , -1 , 1};

        while(!q.isEmpty()){
            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];

            for(int k=0 ; k<4 ; k++){
                int nr = r + dr[k];
                int nc = c + dc[k];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m && mat[nr][nc] == -1){
                    mat[nr][nc] = mat[r][c] + 1;

                    q.add(new int[]{nr,nc});
                }
            }
        }
        return mat;
    }
}