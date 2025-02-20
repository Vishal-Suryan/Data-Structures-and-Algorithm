import java.util.ArrayList;
public class cycleInDirectedGraph {
    class Solution {
    // Function to detect cycle in a directed graph.
        public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
            // code here
            int n = adj.size();
            int[] vis = new int[n];
            int[] pathVis = new int[n];
            for(int i = 0; i<n; i++){
                if(dfs(i,adj,vis,pathVis)) return true;
            }
            return false;
        }
        private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, 
        int[] vis, int[] pathVis){
            vis[node] = 1;
            pathVis[node] = 1;
            for(int itr : adj.get(node)){
                if(vis[itr] == 0){
                    if(dfs(itr,adj,vis,pathVis)) return true;
                }else if(pathVis[itr] == 1) return true;
            }
            pathVis[node] = 0;
            return false;
        }
    }
}
