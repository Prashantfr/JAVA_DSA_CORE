//problem link :chttps://leetcode.com/problems/maximum-width-of-binary-tree/description/
//problem name : Maximum Width of Binary Tree

//Solution with time complexity of O(n) and space complexity O(h).

package Binary_Trees;
import java.util.*;

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        int maxWidth = 0;

        while(!q.isEmpty()){
            int size = q.size();
            int minIndex = q.peek().index;
            int first = 0;
            int last = 0;
            for(int i=0; i<size; i++){
                Pair p = q.poll();
                TreeNode node = p.node;
                int index = p.index - minIndex;
                if(i == 0) first = index;
                if(i == size - 1) last = index;
                if(node.left != null){
                    q.offer(new Pair(node.left , 2*index+1));
                }
                if(node.right != null){
                    q.offer(new Pair(node.right , 2*index+2));
                }
            }
            maxWidth = Math.max(maxWidth , last-first+1);
        }
        return maxWidth;
    }

 class Pair{
    TreeNode node;
    int index;
    Pair(TreeNode node, int index){
        this.node = node;
        this.index = index;
    }
  }
}
