import java.util.*;
class postOrder{
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
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ans= new ArrayList<>();
            helper(root,ans);
            return ans;
        }
        private void helper(TreeNode root, List<Integer> ans){
            if(root==null){
                return;
            }
            helper(root.left,ans);
            helper(root.right,ans);
            ans.add(root.val);
            return;
        }
        public List<Integer> postorderTraversalUsing2Stack(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if(root==null) return ans;
            Stack<TreeNode> st1 =new Stack<>();
            Stack<TreeNode> st2 =new Stack<>();
            st1.push(root);
            while(!st1.isEmpty()){
                root=st1.pop();
                st2.push(root);
                if(root.left!=null) st1.push(root.left);
                if(root.right!=null) st1.push(root.right);
            }
            while(!st2.isEmpty()){
                ans.add(st2.pop().val);
            }
            
            return ans;
        }
        public List<Integer> postorderTraversalUsing1stack(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if(root==null) return ans;
            Stack<TreeNode> st1 =new Stack<>();
            TreeNode curr =root;
            while(curr!=null || !st1.isEmpty()){
                if(curr!=null){
                    st1.push(curr);
                    curr=curr.left;
                }else{
                    TreeNode temp=st1.peek().right;
                    if(temp==null){
                        temp=st1.peek();
                        st1.pop();
                        ans.add(temp.val);
                        while(!st1.isEmpty() && temp==st1.peek().right){
                            temp=st1.peek();
                            st1.pop();
                            ans.add(temp.val);
                        }
                    }else{
                        curr=temp;
                    }
                }
            }
            return ans;
        }
    }
}
