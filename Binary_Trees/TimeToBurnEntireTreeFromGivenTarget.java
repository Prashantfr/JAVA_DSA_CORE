//problem link : https://takeuforward.org/plus/dsa/problems/minimum-time-taken-to-burn-the-bt-from-a-given-node?source=strivers-a2z-dsa-track
//problem name : Minimum time taken to burn the BT from a given Node

//Solution with time complexity of O(n) and space complexity O(n).

package Binary_Trees;
import java.util.*;

class Solution {
    public int minTime(TreeNode root, TreeNode target) {

        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, parentMap);

        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();

        q.offer(target);
        visited.add(target);

        int time = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            time++;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (node.left != null && !visited.contains(node.left)) {
                    q.offer(node.left);
                    visited.add(node.left);
                }

                if (node.right != null && !visited.contains(node.right)) {
                    q.offer(node.right);
                    visited.add(node.right);
                }

                if (parentMap.containsKey(node) && !visited.contains(parentMap.get(node))) {
                    q.offer(parentMap.get(node));
                    visited.add(parentMap.get(node));
                }
            }
        }

        return time;
    }

    private void buildParentMap(TreeNode root, HashMap<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node.left != null) {
                parentMap.put(node.left, node);
                q.offer(node.left);
            }

            if (node.right != null) {
                parentMap.put(node.right, node);
                q.offer(node.right);
            }
        }
    }
}