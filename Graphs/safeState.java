import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class safeState {
    /// BFS Solution ///
    class Solution {
        public List<Integer> eventualSafeNodes(int[][] graph) {
            int n = graph.length;
            ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
            for(int i = 0; i<n; i++){
                adjRev.add(new ArrayList<>());
            }
            int[] inDegree = new int[n];
            for(int i = 0; i<n; i++){
                for(int itr : graph[i]){
                    adjRev.get(itr).add(i);
                    inDegree[i]++;
                }
            }
            Queue<Integer> q = new LinkedList<>();
            List<Integer> safeNodes = new ArrayList<>();
            for(int i = 0; i<n; i++){
                if(inDegree[i] == 0) q.offer(i);
            }
            while(!q.isEmpty()){
                int node = q.poll();
                safeNodes.add(node);
                for(int itr : adjRev.get(node)){
                    inDegree[itr]--;
                    if(inDegree[itr] == 0) q.offer(itr);
                }
            }
            Collections.sort(safeNodes);
            return safeNodes;
        }
    }
    // DFS Solution //
    class SolutionDFS {
        public List<Integer> eventualSafeNodes(int[][] graph) {
            int n = graph.length;
            int[] vis = new int[n];
            int[] pathVis = new int[n];
            int[] check = new int[n];
            for(int i = 0; i<n; i++){
                if(vis[i] == 0){
                    dfs(i, vis, pathVis, check, graph);
                }
            }
            List<Integer> res = new ArrayList<>();
            for(int i = 0; i<n; i++){
                if(check[i] == 1){
                    res.add(i);
                }
            }
            return res;
        }
        private boolean dfs(int node, int[] vis, int[] pathVis, int[] check, int[][] graph){
            vis[node] = 1;
            pathVis[node] = 1;
            check[node] = 0;
            for(int itr : graph[node]){
                if(vis[itr] == 0){
                    if(dfs(itr, vis, pathVis, check, graph)){
                        return true;
                    }
                }else if(pathVis[itr] == 1){
                    return true;
                }
            }
            check[node] = 1;
            pathVis[node] = 0;
            return false;
        }
    }
}
