import java.util.Arrays;

public class bellmanFordAlgo {
    class Solution {
    static int[] bellmanFord(int V, int[][] edges, int src) {
        // Write your code here
        int[] dist = new int[V];
        Arrays.fill(dist, (int)10e7);
        dist[src] = 0;
        for(int i = 0; i < V - 1; i++){
            for(int[] itr : edges){
                int u = itr[0];
                int v = itr[1];
                int wgt = itr[2];
                if(dist[u] != (int)10e7 && dist[u] + wgt < dist[v]){
                    dist[v] = dist[u] + wgt;
                }
            }
        }
        for(int[] itr : edges){
            int u = itr[0];
            int v = itr[1];
            int wgt = itr[2];
            if(dist[u] != (int)10e7 && dist[u] + wgt < dist[v]){
                return new int[]{-1};
            }
        }
        return dist;
    }
}
}
