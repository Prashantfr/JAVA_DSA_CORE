//problem link : https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/
//problem name : Construct Binary Search Tree from Preorder Traversal

//brute force solution with time complexity of O(n²) and space complexity O(n).
//not valid

package Binary_Search_Tree;

class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder , Integer.MIN_VALUE , Integer.MAX_VALUE);
    }

    public TreeNode build(int[] preorder , int start , int end){
        if(start > end) return null;

        TreeNode root = new TreeNode(preorder[start]);

        int i = start+1;
        while(i <= end && preorder[i] < root.val){
            i++;
        }

        root.left = build(preorder , start+1 , i-1);

        root.right = build(preorder , i+1 , end);

        return root;
    }
}