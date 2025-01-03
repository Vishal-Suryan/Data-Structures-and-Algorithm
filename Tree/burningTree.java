import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class burningTree {
    class Solution {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static int minTime(Node root, int target) {
        // code here
        Map<Node,Node> parentNodeMap=new HashMap<>();
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        Node nodeTarget=null;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Node curr=q.poll();
                if(curr.data==target){
                    nodeTarget=curr;
                }
                if(curr.left!=null){
                    q.offer(curr.left);
                    parentNodeMap.put(curr.left,curr);
                } 
                if(curr.right!=null){
                    q.offer(curr.right);
                    parentNodeMap.put(curr.right,curr);
                }
            }  
        }
        Map<Node,Boolean> isVisited=new HashMap<>();
        isVisited.put(nodeTarget,true);
        int time=0;
        q.offer(nodeTarget);
        while(!q.isEmpty()){
            int size=q.size();
            boolean burnedAnyNode = false;
            for(int i=0;i<size;i++){
                Node curr=q.poll();
                if(curr.left!=null && isVisited.get(curr.left)==null){
                    isVisited.put(curr.left,true);
                    q.offer(curr.left);
                    burnedAnyNode = true;
                }
                if(curr.right!=null && isVisited.get(curr.right)==null){
                    isVisited.put(curr.right,true);
                    q.offer(curr.right);
                    burnedAnyNode = true;
                }
                Node parent=parentNodeMap.get(curr);
                if(parent!=null && isVisited.get(parent)==null){
                    isVisited.put(parent,true);
                    q.offer(parent);
                    burnedAnyNode = true;
                }
            }
            if(burnedAnyNode) time++;
        }
        return time;
    }
}
}
