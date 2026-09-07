//problem link : https://leetcode.com/problems/binary-tree-inorder-traversal/description/
//problem name : Binary Tree Inorder Traversal

//Solution with time complexity of O(n) and space complexity O(h).

package Binary_Trees;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }

    void helper(TreeNode root, List<Integer> ans){
        if(root == null) return;
        helper(root.left, ans);
        ans.add(root.val);
        helper(root.right, ans);
    }
 }
}
