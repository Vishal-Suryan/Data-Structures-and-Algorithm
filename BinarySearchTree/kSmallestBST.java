import java.util.Stack;

public class kSmallestBST {
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
        public int kthSmallest(TreeNode root, int k) {
            Stack<TreeNode> st=new Stack<>();
            TreeNode curr=root;
            TreeNode kSmallest=null;
            while(true){
                if(curr!=null){
                    st.push(curr);
                    curr=curr.left;
                }else{
                    if(st.isEmpty() || k==0) break;
                    if(k>0){
                        kSmallest=st.pop();
                        curr=kSmallest.right;
                    }
                    k--;
                }
            }
            return kSmallest.val;
        }
    }
}
