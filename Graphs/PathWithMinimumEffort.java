//problem link : https://leetcode.com/problems/path-with-minimum-effort/description/
//problem name : Path With Minimum Effort

//Solution with time complexity of O(mnlog(mn)) and space complexity O(mn).

package Graphs;
import java.util.*;

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] dist = new int[m][n];

        for(int i=0 ; i<m ; i++){
            Arrays.fill(dist[i] , Integer.MAX_VALUE);
        }

        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[0] , b[0])
        );

        pq.offer(new int[] {0,0,0});

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int effort = curr[0];
            int row = curr[1];
            int col = curr[2];

            if(effort > dist[row][col]){
                continue;
            }

            if(row == m-1 && col == n-1){
                return effort;
            }

            for(int i=0 ; i<4 ; i++){
                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n){
                    int diff = Math.abs(heights[row][col] - heights[newRow][newCol]);
                    
                    int newEffort = Math.max(effort , diff);

                    if(newEffort < dist[newRow][newCol]){
                        dist[newRow][newCol] = newEffort;
                        pq.offer(new int[] {
                            newEffort , newRow , newCol
                        });
                    }
                }
            }
        }
        return 0;
    }
}
