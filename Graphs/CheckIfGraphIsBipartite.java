//problem link : https://leetcode.com/problems/is-graph-bipartite/description/
//problem name : Is Graph Bipartite?

//Solution with time complexity of O(V + E) and space complexity O(V).

package Graphs;
import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        
        int[] color = new int[n];

        for(int i=0 ; i<n ; i++){
            color[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0 ; i<n ; i++){
            if(color[i] == -1){
                color[i] = 0;
                q.add(i);

                while(!q.isEmpty()){
                    int node = q.poll();

                    for (int j = 0; j < graph[node].length; j++) {
                        int neighbor = graph[node][j];

                        if (color[neighbor] == -1) {
                            color[neighbor] = 1 - color[node];
                            q.add(neighbor);
                        } 
                        else if (color[neighbor] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}