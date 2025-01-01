import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class topViewBT {
    
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

    static class Pair{
    Node node;
    int column;
    public Pair(Node node,int column){
        this.node= node;
        this.column= column;
    }
}
class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> ans =new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<Pair> q =new LinkedList<Pair>();
        TreeMap<Integer,Integer> map=new TreeMap<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair p=q.poll();
            Node node=p.node;
            int col=p.column;
            if(!map.containsKey(col)){
                map.put(col,node.data);
            }
            if(node.left!=null){
                q.offer(new Pair(node.left,col-1));
            }
            if(node.right!=null){
                q.offer(new Pair(node.right,col+1));
            }
        }
        for (Integer value : map.values()) {
            ans.add(value);
        }
        return ans;
    }
}
}
