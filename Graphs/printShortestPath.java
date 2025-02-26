import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class printShortestPath {
    
class Solution {
    class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wgt = edge[2];
            adj.get(u).add(new Pair(v, wgt));
            adj.get(v).add(new Pair(u, wgt));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.first - y.first);
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int[] parent = new int[n + 1];
        for(int i = 1; i<=n; i++) parent[i] = i;
        dist[1] = 0;
        pq.offer(new Pair(0,1));
        while(!pq.isEmpty()){
            int distance = pq.peek().first;
            int node = pq.peek().second;
            pq.poll();
            for(Pair neighbour : adj.get(node)){
                if(distance + neighbour.second < dist[neighbour.first]){
                     dist[neighbour.first] = distance + neighbour.second;
                     pq.offer(new Pair(distance + neighbour.second, neighbour.first));
                     parent[neighbour.first] = node;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        if(dist[n] == Integer.MAX_VALUE){
            res.add(-1);
            return res;
        }
        int node = n;
        while(parent[node] != node){
            res.add(node);
            node = parent[node];
        }
        res.add(1);
        Collections.reverse(res);
        res.add(0, dist[n]);
        return res;
    }
}
}
