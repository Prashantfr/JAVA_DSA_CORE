//problem link : https://leetcode.com/problems/asteroid-collision/description/
//problem name : Asteroid collision

//brute force solution with time complexity of O(N²) (worst case multiple passes) and space complexity O(n).

package Stack_Queue;
import java.util.*;

/*class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        boolean changed = true;

        while (changed) {
            changed = false;
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < asteroids.length; i++) {
                if (i < asteroids.length - 1 && asteroids[i] > 0 && asteroids[i + 1] < 0) {
                    // collision
                    changed = true;

                    if (Math.abs(asteroids[i]) > Math.abs(asteroids[i + 1])) {
                        list.add(asteroids[i]); // right one destroyed
                    } else if (Math.abs(asteroids[i]) < Math.abs(asteroids[i + 1])) {
                        list.add(asteroids[i + 1]); // left one destroyed
                    }
                    // if equal → both destroyed → add nothing

                    i++; // skip next
                } else {
                    list.add(asteroids[i]);
                }
            }

            // convert back to array
            asteroids = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                asteroids[i] = list.get(i);
            }
        }

        return asteroids;
    }
}*/

//optimal solution with time complexity of O(n)(each element pushed/popped once) and space complexity O(n).
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<asteroids.length; i++){
            int a = asteroids[i];
            boolean destroyed = false;

            while(!st.isEmpty() && st.peek() > 0 && a < 0){
                if(st.peek() < -a){
                    st.pop();
                    continue;
                }
                else if(st.peek() == -a){
                    st.pop();
                }
                destroyed = true;
                break;
            }
            if(!destroyed){
                st.push(a);
            }
        }
        int[] res = new int[st.size()];
        for(int i=res.length-1; i>=0; i--){
            res[i] = st.pop();
        }
        return res;
    }
}