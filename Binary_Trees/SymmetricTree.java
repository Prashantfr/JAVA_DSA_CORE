//problem link : https://leetcode.com/problems/symmetric-tree/description/
//problem name : Symmetric Tree

//Solution with time complexity of O(n) and space complexity O(h)(recursive stack).

package Binary_Trees;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode l, TreeNode r){
        if(l == null && r == null) return true;

        if(l == null || r == null || l.val != r.val) return false;

        return isMirror(l.left, r.right) && isMirror(l.right, r.left);
    }
}
