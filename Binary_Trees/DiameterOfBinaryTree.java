//problem link : https://leetcode.com/problems/diameter-of-binary-tree/description/
//problem name : Diameter of Binary Tree 

//Solution with time complexity of O(n) and space complexity O(h).

package Binary_Trees;

class Solution {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    private int height(TreeNode node){
        if(node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);

        diameter = Math.max(diameter, left+right);

        return 1 + Math.max(left, right);
    }
}