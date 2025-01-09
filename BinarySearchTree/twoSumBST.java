import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class twoSumBST {
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
        public boolean findTarget(TreeNode root, int k) {
            HashSet<Integer>set=new HashSet<>();
            Queue<TreeNode>q=new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()){
                TreeNode curr=q.poll();
                if (set.contains(curr.val)) {
                    return true;
                }
                set.add(k - curr.val);
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
            return false;
        }
    }
    class Solution2 {
        public boolean findTarget(TreeNode root, int k){
            if(root==null) return false;
            BSTIterator l=new BSTIterator(root,false);
            BSTIterator r=new BSTIterator(root,true);
            int low=l.next();
            int high=r.next();
            while(low<high){
                if(low+high==k) return true;
                else if(low+high<k) low=l.next();
                else high=r.next();
            }
            return false;
        }
    
    }
    class BSTIterator {
        Stack<TreeNode> st=new Stack<>();
        boolean reverse=true;
        public BSTIterator(TreeNode root,boolean isRev){
            reverse=isRev;
            pushAll(root);
        }
        public int next(){
            TreeNode node=st.pop();
            if(reverse==true) pushAll(node.left);
            else pushAll(node.right);
            return node.val;
        }
        public void pushAll(TreeNode root){
            while(root!=null){
                st.push(root);
                if(reverse==true) root=root.right;
                else root=root.left;
            }
        }
    }
}
