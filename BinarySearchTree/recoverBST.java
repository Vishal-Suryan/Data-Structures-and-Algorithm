
public class recoverBST {
    class Solution {
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
        private TreeNode first;
        private TreeNode middle;
        private TreeNode prev;
        private TreeNode last;
        public void recoverTree(TreeNode root) {
            inorder(root);
            if(last==null){
                swap(first,middle);
            }else{
                swap(first,last);
            }
            return;
        }
        private void swap(TreeNode node1, TreeNode node2) {
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }
        private void inorder(TreeNode root){
            if(root==null) return;
            inorder(root.left);
            if(prev!=null && root.val<prev.val){
                if(first==null){
                    first=prev;
                    middle=root;
                }else{
                    last=root;
                }
            }
            prev=root;
            inorder(root.right);
            return;
        }
    }
}
