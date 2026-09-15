//problem link : https://leetcode.com/problems/count-complete-tree-nodes/description/
//problem name : Count Complete Tree Nodes

//Brute force solution with time complexity of O(n) and space complexity O(h).

package Binary_Trees;

class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}