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

    public List<TreeNode> solve(int st, int end){
        if(st > end){
            List<TreeNode> lst = new ArrayList<>();
            lst.add(null);
            return lst;
        }
        if(st == end){
            List<TreeNode> lst = new ArrayList<>();
            lst.add(new TreeNode(st));
            return lst;
        }
        List<TreeNode> lst = new ArrayList<>();
        for(int i = st; i <= end; i++){

            List<TreeNode> left = solve(st, i-1);
            List<TreeNode> right = solve(i+1, end);
            
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    lst.add(root);
                }
            }
        }

        return lst;
    }

    public List<TreeNode> generateTrees(int n) {
        return solve(1, n);
    }
}