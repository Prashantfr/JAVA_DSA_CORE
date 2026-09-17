//problem link : https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
//problem name :  Flatten Binary Tree to Linked List

//Brute force solution with time complexity of O(n) and space complexity O(n)(extra list).

package Binary_Trees;
import java.util.*;

class Solution {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorder(root, list);

        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }
    }

    public void preorder(TreeNode node, List<TreeNode> list) {
        if (node == null) return;

        list.add(node);
        preorder(node.left, list);
        preorder(node.right, list);
    }
}
