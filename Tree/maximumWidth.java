import java.util.LinkedList;
import java.util.Queue;
public class maximumWidth {
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
    class Pair{
    TreeNode node;
    int index;
    public Pair(TreeNode _node,int _index){
        node= _node;
        index= _index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int ans=0;
        if(root==null) return ans;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            int min=q.peek().index;
            int first=0,last=0;
            for(int i=0;i<size;i++){
                int curr=q.peek().index-min;
                TreeNode node=q.peek().node;
                q.poll();
                if(i==0){
                   first=curr;  
                }
                if(i==size-1){
                    last=curr;
                }
                if(node.left!=null){
                    q.offer(new Pair(node.left,2*curr+1));
                } 
                if(node.right!=null){
                    q.offer(new Pair(node.right,2*curr+2));
                } 
            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
}
}
