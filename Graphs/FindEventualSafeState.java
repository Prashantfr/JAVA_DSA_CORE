//problem link : https://leetcode.com/problems/find-eventual-safe-states/description/
//problem name : Find Eventual Safe States.

//Solution with time complexity of O(V + E + VlogV) and space complexity O(V + E).

package Graphs;
import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0 ; i<n ; i++){
            adj.add(new ArrayList<>());
        }

        int[] outdegree = new int[n];

        for(int i=0 ; i<n ; i++){
            for(int node : graph[i]){
                adj.get(node).add(i);
                outdegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i=0 ; i<n ; i++){
            if(outdegree[i] == 0){
                q.offer(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(int prev : adj.get(node)){
                outdegree[prev]--;
                if(outdegree[prev] == 0){
                    q.offer(prev);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
