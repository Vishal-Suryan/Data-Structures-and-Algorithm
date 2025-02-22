import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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
    // Function to detect cycle in a directed graph. USing BFS Traversal of Graph
    class SolutionBFS {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int size = adj.size();
        ArrayList<Integer> topoSort = topologicalSort(adj);
        return !(topoSort.size() == size);
    }
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        int n = adj.size();
        int[] inDegree = new int[n];
        for(int i = 0; i<n; i++){
            for(int itr : adj.get(i)){
                inDegree[itr]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        //int i = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            for(int itr : adj.get(node)){
                inDegree[itr]--;
                if(inDegree[itr] == 0){
                    q.offer(itr);
                }
            }
        }
        return res;
    }
}
}
