import java.util.*;
class inOrder{
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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans= new ArrayList<>();
            helper(root,ans);
            return ans;
        }
        private void helper(TreeNode root, List<Integer> ans){
            if(root==null){
                return;
            }
            helper(root.left,ans);
            ans.add(root.val);
            helper(root.right,ans);
            return;
        }
    }
    public List<Integer> inorderTraversalUsingStack(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Stack<TreeNode> st =new Stack<>();
        TreeNode node=root;
        while(true){
            if(node!=null){
                st.push(node);
                node=node.left;
            }else{
                if(st.isEmpty()) break;
                node = st.pop();
                ans.add(node.val);
                node=node.right;
            }
        }
        return ans;
    }
}
