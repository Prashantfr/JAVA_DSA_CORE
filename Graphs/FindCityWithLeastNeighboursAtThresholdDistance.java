//problem link : https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/
//problem name : Find the City With the Smallest Number of Neighbors at a Threshold Distance.

//Solution with time complexity of O(n³) and space complexity O(n²).

package Graphs;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dist[][] = new int[n][n];
        int INF = 100000000;

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                if(i == j){
                    dist[i][j] = 0;
                }
                else{
                    dist[i][j] = INF;
                }
            }
        }

        for(int i=0 ; i<edges.length ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        for(int k=0 ; k<n ; k++){
            for(int i=0 ; i<n ; i++){
                for(int j=0 ; j<n ; j++){

                    if(dist[i][k] != INF && dist[k][j] != INF){
                        dist[i][j] = Math.min(dist[i][j] , dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        int minCount = n;
        int bestCity = -1;

        for(int i=0 ; i<n ; i++){
            int count = 0;

            for(int j=0 ; j<n ; j++){
                if(i != j && dist[i][j] <= distanceThreshold){
                    count++;
                }
            }

            if(count <= minCount){
                minCount = count;
                bestCity = i;
            }
        }
        return bestCity;
    }
}
