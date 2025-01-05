
public class insertBST {
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
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if(root==null) return new TreeNode(val);
            TreeNode curr=root;
            while(true){
                if(curr.val>val){
                    if(curr.left!=null){
                        curr=curr.left;
                    }else{
                        curr.left=new TreeNode(val);
                        break;
                    }
                }else{
                    if(curr.right!=null){
                        curr=curr.right;
                    }else{
                        curr.right=new TreeNode(val);
                        break;
                    }
                }
            }
            return root;
        }
    }
}
