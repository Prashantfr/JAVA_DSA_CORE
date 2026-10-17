//problem link : https://leetcode.com/problems/network-delay-time/description/
//problem name : Network Delay Time.

//Solution with time complexity of O(n³) and space complexity O(n²).

package Graphs;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int dist[][] = new int[n+1][n+1];
        int INF = 100000000;
        
        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=n ; j++){
                if(i == j){
                    dist[i][j] = 0;
                }
                else{
                    dist[i][j] = INF;
                }
            } 
        }

        for(int i=0 ; i<times.length ; i++){
            int u = times[i][0];
            int v = times[i][1];
            int wt = times[i][2];

            dist[u][v] = Math.min(dist[u][v] , wt);
        }

        for(int via=1 ; via<=n ; via++){
            for(int i=1 ; i<=n ; i++){
                for(int j=1 ; j<=n ; j++){
                    if(dist[i][via] != INF && dist[via][j] != INF){
                        dist[i][j] = Math.min(dist[i][j] , dist[i][via] + dist[via][j]);
                    }
                }
            }
        }

        int ans = 0;

        for(int i=1 ; i<=n ; i++){
            if(dist[k][i] == INF){
                return -1;
            }
            ans = Math.max(ans , dist[k][i]);
        }
        return ans;
    }
}
