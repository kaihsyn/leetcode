/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution124 {
    private int max = 0;
    
    public int maxPathSum(TreeNode root) {
        max = root.val;
        getMax(root);
        return max;
    }
    
    private int getMax(TreeNode node) {
        if(node == null) return 0;
        
        int path_max = node.val;
        int left = 0;
        int right = 0;
        
        if(node.left != null) {
            left = getMax(node.left);
            path_max = Math.max(path_max, node.val + left);
        }
        
        if(node.right != null) {
            right = getMax(node.right);
            path_max = Math.max(path_max, node.val + right);
        }
        
        int node_max = node.val;
        if(left > 0) node_max += left;
        if(right > 0) node_max += right;
        if(node_max > max) max = node_max;

        return path_max;
    }
}