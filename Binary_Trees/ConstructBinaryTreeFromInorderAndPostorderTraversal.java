//problem link : https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
//problem name : Construct Binary Tree from Inorder and Postorder Traversal

//Solution with time complexity of O(n) and space complexity O(n).

package Binary_Trees;
import java.util.*;

class Solution {

    int postIndex;
    HashMap<Integer , Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0 ; i<inorder.length ; i++){
            map.put(inorder[i],i);
        }
        postIndex = postorder.length-1;

        return build(postorder , 0 , inorder.length -1);
    }

    public TreeNode build(int[] postorder , int inStart , int inEnd){
        if(inStart > inEnd) return null;

        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = map.get(rootVal);

        root.right = build(postorder , inIndex+1 , inEnd);
        root.left = build(postorder , inStart , inIndex-1);

        return root;
    }
}
