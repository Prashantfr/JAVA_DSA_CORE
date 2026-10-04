//problem link : https://leetcode.com/problems/binary-tree-level-order-traversal/
//problem name : Binary Tree Level Order Traversal

//Solution with time complexity of O(n) and space complexity O(n)(queue).
//Breadth first search
package Binary_Trees;
import java.util.*;
class Solution {
 public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();

    if(root == null) return ans;

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while(!q.isEmpty()){
        int size = q.size();
        List<Integer> level = new ArrayList<>();

        for(int i=0; i<size; i++){
            TreeNode node = q.poll();
            level.add(node.val);
            if(node.left != null) q.offer(node.left);
            if(node.right != null) q.offer(node.right);
        }
        ans.add(level);
    }
    return ans;
  }
}
