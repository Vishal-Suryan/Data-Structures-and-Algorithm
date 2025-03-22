import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class countConnectedComp_2685 {
    class Solution {
        public int countCompleteComponents(int n, int[][] edges) {
            List<List<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < n; i++){
                adj.add(new ArrayList<>());
            }
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            boolean[] vis = new boolean[n];
            int count = 0;
            for(int i = 0; i< n; i++){
                if(!vis[i]){
                    List<Integer> com = new ArrayList<>();
                    if(bfs(i ,adj, vis, com) && isComplete(com, adj)){
                        count++;
                    }
                }
            }
            return count;
        }
        public boolean bfs(int start, List<List<Integer>> adjList, boolean visited[], List<Integer> com){
            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            visited[start]=true;
            while(!q.isEmpty()){
                int node = q.poll();
                com.add(node);
                for(int neg : adjList.get(node)){
                    if(!visited[neg]){
                        visited[neg]=true;
                        q.add(neg);
                    }
                }
            }
            return true;    
        }
         private boolean isComplete(List<Integer> component, List<List<Integer>> adjList) {
            int size = component.size();
            for (int node : component) {
                if (adjList.get(node).size() != size - 1) {
                    return false;
                }
            }
            return true;
        }
    }
}
