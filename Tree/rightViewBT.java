import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;



public class rightViewBT {
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
    int row;
    public Pair(TreeNode _node, int _row){
        node= _node;
        row= _row;
    }
 }
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans =new ArrayList<>();
        if(root==null) return ans;
        Queue<Pair> q=new LinkedList<>();
        TreeMap<Integer,Integer> map=new TreeMap<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair p =q.poll();
            TreeNode node=p.node;
            int row=p.row;
            if(!map.containsKey(row)){
                map.put(row,node.val);
            }
            if(node.right!=null){
                q.offer(new Pair(node.right,row+1));
            }
            if(node.left!=null){
                q.offer(new Pair(node.left,row+1));
            }
        }
        for(Integer value : map.values()){
            ans.add(value);
        }
        return ans;
    }
}
}
