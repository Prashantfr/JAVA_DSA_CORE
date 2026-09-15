//problem link : https://takeuforward.org/plus/dsa/problems/print-root-to-note-path-in-bt?source=strivers-a2z-dsa-track
//problem name : Print root to leaf path in BT

//Solution with time complexity of O(n) and space complexity O(h).

package Binary_Trees;
import java.util.*;

class Solution {
    public List<List<Integer>> allRootToLeaf(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(root, path, ans);
        return ans;
    }

    private void helper(TreeNode node, List<Integer> path, List<List<Integer>> ans){
        if(node == null) return;

        path.add(node.val);

        if(node.left == null && node.right == null){
            ans.add(new ArrayList<>(path));
        }
        else{
            helper(node.left , path, ans);
            helper(node.right , path, ans);
        }
        path.remove(path.size()-1);
    }
}