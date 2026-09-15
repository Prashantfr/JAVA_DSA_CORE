//problem link : https://leetcode.com/problems/count-complete-tree-nodes/description/
//problem name : Count Complete Tree Nodes

//Brute force solution with time complexity of O(n) and space complexity O(h).

package Binary_Trees;

/*class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}*/

//Optimal solution with time complexity of O((log N)²)(height calculation O(log N) for each recursion) and space complexity O(logN).
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        if(leftHeight == rightHeight){
            return (1 << leftHeight) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getLeftHeight(TreeNode node){
        int height = 0;
        while(node != null){
            height++;
            node = node.left;
        }
        return height;
    }

    private int getRightHeight(TreeNode node){
        int height = 0;
        while(node != null){
            height++;
            node = node.right;
        }
        return height;
    }
}