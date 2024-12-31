import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

import javax.swing.tree.TreeNode;

public class verticalOrderBT {
    class Tuple{
        TreeNode node;
        int row;
        int col;
        public Tuple(TreeNode _node,int _row,int _col){
            node= _node;
            row= _row;
            col= _col;
        }
    }
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
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> mp=new TreeMap<>();
            Queue<Tuple> q=new LinkedList<Tuple>();
            q.offer(new Tuple(root,0,0));
            while(!q.isEmpty()){
                Tuple tuple=q.poll();
                TreeNode node=tuple.node;
                int row=tuple.row;
                int col=tuple.col;
                if(!mp.containsKey(col)){
                    mp.put(col,new TreeMap<>());
                }
                if(!mp.get(col).containsKey(row)){
                    mp.get(col).put(row,new PriorityQueue<>());
                }
                mp.get(col).get(row).offer(node.val);
                if(node.left !=null){
                    q.offer(new Tuple(node.left,row+1,col-1));
                }
                if(node.right !=null){
                    q.offer(new Tuple(node.right,row+1,col+1));
                }
            }
            List<List<Integer>> list=new ArrayList<>();
            for(TreeMap<Integer,PriorityQueue<Integer>> ys:mp.values()){
                list.add(new ArrayList<>());
                for(PriorityQueue<Integer> nodes: ys.values()){
                    while(!nodes.isEmpty()){
                        list.get(list.size()-1).add(nodes.poll());
                    }
                }
            }
            return list;
        }
    }
}
