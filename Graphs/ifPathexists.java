import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
public class ifPathexists {
    // dfs on Adjacency Matrix 
/*     class Solution {
        public boolean validPath(int n, int[][] edges, int source, int destination) {
            boolean[][] graph=new boolean[n][n];
            for(boolean[] row:graph){
                Arrays.fill(row,false);
            }
            for(int[] edge:edges){
                int u=edge[0];
                int v=edge[1];
                graph[u][v]=true;
                graph[v][u]=true;
            }
            boolean[] vis=new boolean[n];
            return dfs(graph,source,destination,vis,n);

                // bfs on adjacency matrix
            /* boolean[] vis=new boolean[n];
            Queue<Integer> q=new LinkedList<>();
            vis[source]=true;
            q.offer(source);
            while(!q.isEmpty()){
                int node=q.poll();
                if(node==destination){
                    return true;
                }
                for(int i=0;i<n;i++){
                    if(graph[node][i] == true && !vis[i]){
                        q.offer(i);
                        vis[i]=true;
                    }
                }
            }
            return false; 
        }
        private boolean dfs(boolean[][] graph,int src,int dest,boolean[] vis,int n){
            if(src==dest) return true;
            vis[src]=true;
            for(int i=0;i<n;i++){
                if(graph[src][i]==true && !vis[i]){
                    if(dfs(graph,i,dest,vis,n)){
                        return true;
                    }
                }
            }
            return false;
        }
    } */
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer,List<Integer>> graph=new HashMap<>();
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            graph.computeIfAbsent(u,value->new ArrayList<>()).add(v);
            graph.computeIfAbsent(v,value->new ArrayList<>()).add(u);
        }
        boolean[] vis=new boolean[n];
         Queue<Integer> q=new LinkedList<>();
        q.offer(source);
        vis[source]=true;
        while(!q.isEmpty()){
            int node=q.poll();
            if(node==destination) return true;
            for(int neighbour :graph.get(node)){
                if(!vis[neighbour]){
                    q.offer(neighbour);
                    vis[neighbour]=true;
                }
            }
        }
        return false;
        //return dfs(graph,source,destination,vis,n);
    }
    /* private boolean dfs(Map<Integer,List<Integer>> graph,int src,int dest,boolean[] vis,int n){
        if(src==dest){
            return true;
        }
        vis[src]=true;
        for(int neighbour: graph.get(src)){
            if(!vis[neighbour]){
                if(dfs(graph,neighbour,dest,vis,n)){
                    return true;
                }
            }
        }
        return false;
    } */
    
}
