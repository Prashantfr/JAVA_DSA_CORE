//problem link : https://leetcode.com/problems/binary-tree-preorder-traversal/description/
//problem name : Binary Tree Preorder Traversal

//Solution with time complexity of O(n) and space complexity O(h).

package Binary_Trees;
import java.util.*;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }

    void helper(TreeNode root, List<Integer> ans){
        if(root == null) return;
        ans.add(root.val);
        helper(root.left, ans);
        helper(root.right, ans);
    }
}