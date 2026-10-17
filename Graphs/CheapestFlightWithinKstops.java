//problem link : https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
//problem name : Cheapest Flights Within K Stops

//Solution with time complexity of O((k + 1) x E) and space complexity O(n).

package Graphs;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int dist[] = new int[n];
        for(int i=0 ; i<n ; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        for(int i=0 ; i<=k ; i++){
            int[] temp = dist.clone();

            for(int[] flight : flights){
                int u = flight[0];
                int v = flight[1];
                int cost = flight[2];

                if(dist[u] != Integer.MAX_VALUE && dist[u] + cost < temp[v]){
                    temp[v] = dist[u] + cost;
                }
            }
            dist = temp;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}