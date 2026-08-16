/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        int is_balanced = is_balanced_tree(root);
        return is_balanced == -1 ? false : true;
    }

    private int is_balanced_tree(TreeNode root){
        if(root==null)
            return 0;

        int left_height = is_balanced_tree(root.left);
        int right_height = is_balanced_tree(root.right);  

        if(left_height == -1 || right_height == -1)
            return -1;

        if(Math.abs(left_height-right_height) > 1)
            return -1;

        return 1+Math.abs(left_height-right_height);          
    }
}
