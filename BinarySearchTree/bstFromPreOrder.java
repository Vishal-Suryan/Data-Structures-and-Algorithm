
public class bstFromPreOrder {
    public static class TreeNode {
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
        public TreeNode bstFromPreorder(int[] preorder) {
            if(preorder.length==0) return null;
            TreeNode root=new TreeNode(preorder[0]);
            for(int i=1;i<preorder.length;i++){
                helper(root,preorder[i]);
            }
            return root;
        }
        private static void helper(TreeNode root,int key){
            TreeNode node=new TreeNode(key);
            if(root.val>key){
                if(root.left!=null){
                    helper(root.left,key);
                }else{
                    root.left=node;
                }
            }else{
                if(root.val<key){
                    if(root.right!=null){
                        helper(root.right,key);
                    }else{
                    root.right=node;
                    }
                }
            }
            return;
        }
    }
}
