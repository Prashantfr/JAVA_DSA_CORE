//problem link : https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
//problem name : Binary Tree Maximum Path Sum

//Solution with time complexity of O(n) and space complexity O(h)(recursive stack).

package Binary_Trees;

class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    private int helper(TreeNode node){
        if(node == null) return 0;
        int left = Math.max(0 , helper(node.left));
        int right = Math.max(0 , helper(node.right));

        int pathSum = left + node.val + right;

        maxSum = Math.max(pathSum , maxSum);

        return node.val + Math.max(left , right);
    }
}
