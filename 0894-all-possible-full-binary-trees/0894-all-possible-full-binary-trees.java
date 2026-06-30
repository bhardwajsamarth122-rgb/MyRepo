class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        if(n % 2 == 0){
            return new ArrayList<>();
        }
        if(n == 1){
            TreeNode root = new TreeNode(0);
            List<TreeNode> lst = new ArrayList<>();
            lst.add(root);
            return lst;
        }
        List<TreeNode> ans = new ArrayList<>();
        for(int i = 1; i < n; i+=2){
            List<TreeNode> left = allPossibleFBT( i);
            List<TreeNode> right = allPossibleFBT( n-i-1);

            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode node = new TreeNode(0);
                    node.left = l;
                    node.right = r;

                    ans.add(node);
                }
            }
        }

        return ans;
    }
}