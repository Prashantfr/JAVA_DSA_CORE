//problem link : https://leetcode.com/problems/validate-binary-search-tree/description/
//problem name : Validate Binary Search Tree

//Recursive solution with time complexity of O(n) and space complexity O(h).

package Binary_Search_Tree;

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root , Long.MIN_VALUE , Long.MAX_VALUE);
    }

    public boolean helper(TreeNode node , long min , long max){
        if(node == null) return true;

        if(node.val <= min || node.val >= max) return false;

        return helper(node.left , min , node.val) && helper(node.right , node.val , max);
    }
}
