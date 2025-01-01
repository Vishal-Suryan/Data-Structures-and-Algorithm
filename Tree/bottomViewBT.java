import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class bottomViewBT {
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
    class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
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
            map.put(col,node.data);
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
