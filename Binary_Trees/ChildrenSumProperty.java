//problem link : https://takeuforward.org/plus/dsa/problems/children-sum-property-in-binary-tree?source=strivers-a2z-dsa-track
//problem name : Children Sum Property in Binary Tree

//Solution with time complexity of O(n) and space complexity O(h).

package Binary_Trees;

class Solution {
    boolean checkChildrenSum(TreeNode root) { 
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;

        int left = (root.left != null) ? root.left.val : 0;
        int right = (root.right != null) ? root.right.val : 0;

        if(root.val == left + right &&
        checkChildrenSum(root.left) &&
        checkChildrenSum(root.right)){
            return true;
        }
        return false;
    }
}
