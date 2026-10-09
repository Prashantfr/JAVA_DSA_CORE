//problem link : https://leetcode.com/problems/course-schedule/description/
//problem name : Course Schedule.

//Solution with time complexity of O(V + E) and space complexity O(V + E).

package Graphs;
import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0 ; i < numCourses ; i++){
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

        int count = 0;
        while(!q.isEmpty()){
            int course = q.poll();
            count++;

            for(int next : adj.get(course)){
                indegree[next]--;

                if(indegree[next] == 0){
                    q.add(next);
                }
            }
        }
        return count == numCourses;
    }
}
