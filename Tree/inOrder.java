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
    public List<Integer> inorderMorrisTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                // No left child, process current node and move to the right
                result.add(curr.val);
                curr = curr.right;
            } else {
                // Find the inorder predecessor
                TreeNode pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }
                if (pred.right == null) {
                    // Establish thread to current node
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    // Thread exists, revert the tree structure
                    pred.right = null;
                    result.add(curr.val); // Process current node
                    curr = curr.right;
                }
            }
        }
        return result;
    }
}
