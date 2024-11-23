import java.util.*;
class levelOrder{
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans=new ArrayList<>();
            if(root==null){
                return ans;
            }
            Queue<TreeNode> temp =new LinkedList<>();
            temp.offer(root);
            while(!temp.isEmpty()){
                List<Integer> level = new ArrayList<>();
                int lvl=temp.size();
                for(int i=0;i<lvl;i++){
                    TreeNode node=temp.poll();
                    level.add(node.val);
                    if(node.left!=null){
                        temp.offer(node.left);
                    }
                    if(node.right!=null){
                        temp.offer(node.right);
                    }
                }
                ans.add(level);
            }
            return ans;
        }
    }
}
