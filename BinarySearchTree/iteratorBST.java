import java.util.Stack;

public class iteratorBST {
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
    class BSTIterator {
        private Stack<TreeNode> st=new Stack<>();
        public BSTIterator(TreeNode root) {
            pushAll(root);
        }
        
        public int next() {
            TreeNode node=st.pop();
            if(node.right!=null){
                pushAll(node.right);
            }
            return node.val;
        }
        
        public boolean hasNext() {
            return (!st.isEmpty());
        }
    
        private void pushAll(TreeNode root){
            while(root!=null){
                st.push(root);
                root=root.left;
            }
            return;
        }
    }
}
