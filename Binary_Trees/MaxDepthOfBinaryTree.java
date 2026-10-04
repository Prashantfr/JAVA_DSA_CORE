//problem link : https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
//problem name : Maximum Depth of Binary Tree

//Solution with time complexity of O(n) and space complexity O(h).

package Binary_Trees;

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }
}
