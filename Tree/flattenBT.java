import java.util.Stack;
public class flattenBT {
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
        public void flatten(TreeNode root) {
            if(root==null) return;
            Stack<TreeNode> st=new Stack<>();
            st.push(root);
            TreeNode prev=null;
            while(!st.isEmpty()){
                TreeNode node=st.pop();
                if(prev==null){
                    prev=node;
                }else{
                    prev.right=node;
                    prev.left=null;
                    prev=node;
                }
                if(node.right!=null) st.push(node.right);
                if(node.left!=null) st.push(node.left);
            }
            return;
        }
    }
    class Solution2 {
    TreeNode prev=null;
    public void flatten(TreeNode root) {
        if(root==null) return;
        flatten(root.right);
        flatten(root.left);
        root.right=prev;
        root.left=null;
        prev=root;
    }
}
}
