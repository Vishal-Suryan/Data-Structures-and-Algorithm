import java.util.*;
public class tarjansAlgo {
    class Solution {
        private int timer = 1;
        public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
            List<List<Integer>> adj = new ArrayList<>();
            for(int i = 0; i<n; i++){
                adj.add(new ArrayList<>());
            }
            for(List<Integer> itr : connections){
                int u = itr.get(0);
                int v = itr.get(1);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            int[] vis = new int[n];
            int[] tin = new int[n];
            int[] low = new int[n];
            List<List<Integer>> bridges = new ArrayList<>();
            dfs(0, -1, vis, tin, low, bridges, adj);
            return bridges;
        }
        private void dfs(int node, int parent, int[] vis, int[] tin, int[] low,  
        List<List<Integer>> bridges, List<List<Integer>> adj){
            vis[node] = 1;
            tin[node] = low[node] = timer;
            timer++;
            for(Integer itr : adj.get(node)){
                if(itr == parent) continue;
                if(vis[itr] == 0){
                    dfs(itr, node, vis, tin, low, bridges, adj);
                    low[node] = Math.min(low[node], low[itr]);
                    if(low[itr] > tin[node]){
                        bridges.add(Arrays.asList(itr, node));
                    }
                }else{
                    low[node] = Math.min(low[node], low[itr]);
                }
            }
        }
    }
}
