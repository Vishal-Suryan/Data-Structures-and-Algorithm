import java.util.*;
public class primsAlgorithm {
    class Solution {
        static class Pair{
            int distance;
            int node;
            public Pair(int distance, int node){
                this.distance = distance;
                this.node = node;
            }
        }
        static int spanningTree(int V, int E, List<List<int[]>> adj) {
            // Code Here.
            int[] vis = new int[V];
            PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.distance - y.distance);
            pq.offer(new Pair(0, 0));
            int sum = 0;
            while(!pq.isEmpty()){
                Pair temp = pq.poll();
                int node = temp.node;
                int wgt = temp.distance;
                if(vis[node] == 1) continue;
                vis[node] = 1;
                sum+=wgt;
                for (int[] edge : adj.get(node)) {
                    int adjNode = edge[0];  
                    int edW = edge[1];  
                    if (vis[adjNode] == 0) {
                        pq.offer(new Pair(edW, adjNode));
                    }
                }
            }
            return sum;
        }
    }
}
