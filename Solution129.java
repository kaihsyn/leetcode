/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution129 {
    private int sum;
    
    public int sumNumbers(TreeNode root) {
        sum = 0;
        
        if(root != null) {
            DFS(root, 0);
        }
        
        return sum;
    }
    
    private void DFS(TreeNode node, int num) {
        if(node.left == null && node.right == null) {
            sum += num * 10 + node.val;
        }
        
        if(node.left != null) {
            DFS(node.left, num * 10 + node.val);
        }
        
        if(node.right != null) {
            DFS(node.right, num * 10 + node.val);
        }
        
        return;
    }
}