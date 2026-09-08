//problem link : https://leetcode.com/problems/same-tree/description/
//problem name : Same Tree

//Solution with time complexity of O(n) and space complexity O(h).

package Binary_Trees;

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;

        if(p == null || q == null || p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
