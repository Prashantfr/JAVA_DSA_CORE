//problem link : https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
//problem name : Binary Tree Zigzag Level Order Traversal

//Solution with time complexity of O(n) and space complexity O(n).
//using level order traversal + direction control
//Change the direction after adding each level into the result
//Add all the nodes in simple manner if leftToRight and insert at index 0 (front) if !leftToRight to reverse the order of nodes)

package Binary_Trees;
import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean leftToRight = true;

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                if(leftToRight){
                    level.add(node.val);
                }
                else {
                    level.add(0 , node.val);
                }

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            ans.add(level);
            leftToRight = !leftToRight;
        }
        return ans;
    }
}
