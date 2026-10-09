//problem link : https://leetcode.com/problems/course-schedule-ii/description/
//problem name : Course Schedule 2.

//Solution with time complexity of O(V + E) and space complexity O(V + E).

package Graphs;
import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0 ; i<numCourses ; i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for(int[] p : prerequisites){
            int a = p[0];
            int b = p[1];

            adj.get(b).add(a);
            indegree[a]++;
        }
        
        Queue<Integer> q = new LinkedList<>();

        for(int i=0 ; i<numCourses ; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        int[] ans = new int[numCourses];
        int count = 0;

        while(!q.isEmpty()){
            int course = q.poll();
            ans[count++] = course;

            for(int neighbour : adj.get(course)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        if(count == numCourses){
            return ans;
        }
        return new int[0];
    }
}