import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class shortestPathInDAG {
    class Solution {
    class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    private void topoSort(int node, ArrayList<ArrayList<Pair>> adj, 
    int[] vis, Stack<Integer> st){
        vis[node] = 1;
        for(int i = 0; i<adj.get(node).size(); i++){
            int v = adj.get(node).get(i).first;
            if(vis[v] == 0){
                topoSort(v, adj, vis, st);
            }
        }
        st.push(node);
    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++){
            ArrayList<Pair> temp = new ArrayList<>();
            adj.add(temp);
        }
        for(int i = 0; i<E; i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            int wgt = edges[i][2];
            adj.get(src).add(new Pair(dest,wgt));
        }
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<V; i++){
            if(vis[i] == 0){
                topoSort(i, adj, vis, st);
            }
        }
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        while(!st.isEmpty()){
            int node = st.pop();
            if (dist[node] != Integer.MAX_VALUE) { // If the node is reachable
                for (Pair neighbor : adj.get(node)) {
                    int v = neighbor.first;
                    int w = neighbor.second;
                    if (dist[node] + w < dist[v]) {
                        dist[v] = dist[node] + w;
                    }
                }
            }
        }
        for(int i = 0; i<V; i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }
        return dist;
    }
}
}
