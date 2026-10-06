//problem link : https://leetcode.com/problems/number-of-provinces/description/
//problem name : Number of Provinces

//Solution with time complexity of O(n²) and space complexity O(n).

package Graphs;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        int provinces = 0;

        for(int city=0 ; city<n ; city++){
            if(!visited[city]){
                provinces++;
                dfs(city , isConnected , visited);
            }
        }
        return provinces;
    }

    public void dfs(int city , int[][] isConnected , boolean[] visited){
        visited[city] = true;

        for(int neighbour=0 ; neighbour<isConnected.length ; neighbour++){
            if(isConnected[city][neighbour] == 1 && !visited[neighbour]){
                dfs(neighbour , isConnected , visited);
            }
        }
    }
}
