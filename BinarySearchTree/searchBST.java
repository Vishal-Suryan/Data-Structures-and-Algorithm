
public class searchBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if(root==null) return null;
            TreeNode node=null;
            while(root!=null){
                if(root.val==val){
                    node=root;
                    break;
                }else if(root.val>val){
                    root=root.left;
                }else{
                    root=root.right;
                }
            }
            return node;
        }
    }
}
