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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null)
            return true;

        if(root==null)
            return false;

        if(isSameTree(root,subRoot))
            return true;

        return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);                             


    }

    public boolean isSameTree(TreeNode root, TreeNode sub_root){
        if(root == null && sub_root == null)
            return true;

        if( root!=null && sub_root !=null && root.val == sub_root.val){
            return isSameTree(root.left,sub_root.left) && isSameTree(root.right,sub_root.right);
        }else{
            return false;
        }
    }
}
