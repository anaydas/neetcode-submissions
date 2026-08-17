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

    private TreeNode lca = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLCA(root,p,q);
        return lca;
    }

    private boolean findLCA(TreeNode root, TreeNode p, TreeNode q){
        if(root==null)
            return false;

        boolean root_is_p_or_q = root.val == p.val || root.val==q.val ? true : false;
        boolean left_has_p_or_q = findLCA(root.left,p,q);
        boolean right_has_p_or_q = findLCA(root.right,p,q);

        if( (root_is_p_or_q && left_has_p_or_q) 
        || (root_is_p_or_q && right_has_p_or_q) 
        || (left_has_p_or_q && right_has_p_or_q))
            lca = root;

        return root_is_p_or_q || left_has_p_or_q || right_has_p_or_q;
    }
}
