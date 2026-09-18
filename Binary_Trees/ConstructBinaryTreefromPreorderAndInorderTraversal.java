//problem link : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
//problem name : Construct Binary Tree from Preorder and Inorder Traversal

//Solution with time complexity of O(n) and space complexity O(n).

package Binary_Trees;
import java.util.*;

class Solution {
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i=0 ; i<inorder.length ; i++){
            map.put(inorder[i] , i);
        }
        return build(preorder , 0 , inorder.length-1 , map);
    }

    private TreeNode build(int[] preorder , int inStart , int inEnd , HashMap<Integer , Integer> map){
        if(inStart > inEnd) return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = map.get(root.val);

        root.left = build(preorder , inStart , inIndex-1 , map);

        root.right = build(preorder , inIndex+1 , inEnd , map);

        return root;
    }
}