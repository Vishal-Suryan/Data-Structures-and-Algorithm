import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class detectCycleUndirectedGraph {
    // ------ BFS Solution ------ //
    class Solution {
    // Function to detect cycle in an undirected graph.
    class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first=first;
            this.second=second;
        }
    }
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis=new boolean[adj.size()];
        for(int i = 0; i<adj.size(); i++) vis[i] = false;
        for(int i = 0; i<adj.size(); i++){
            if(!vis[i]){
                if(detectCycle(i, adj, vis)) return true;
            }
        }
        return false;
    }
    private boolean detectCycle(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[src]=true;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src,-1));
        while(!q.isEmpty()){
            int node = q.peek().first;
            int parent = q.peek().second;
            q.poll();
            for(int adjacentNode : adj.get(node)){
                if(!vis[adjacentNode]){
                    vis[adjacentNode]=true;
                    q.offer(new Pair(adjacentNode,node));
                }else if(parent!=adjacentNode){
                    return true;
                }
            }
        }
        return false;
    }
}
}
