import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class nWaystoArriveAtDestination {
    class Solution {
    class Pair{
        long first;
        int second;
        public Pair(long first,int second){
            this.first = first;
            this.second = second;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] road : roads){
            int from = road[0];
            int to = road[1];
            int time = road[2];
            adj.get(from).add(new Pair(time,to));
            adj.get(to).add(new Pair(time,from));
        }
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        int[] ways = new int[n];
        Arrays.fill(ways, 0);
        dist[0] = 0;
        ways[0] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) ->Long.compare(x.first , y.first));
        pq.offer(new Pair(0,0));
        int mod = (int) (1e9 + 7);
        while(!pq.isEmpty()){
            Pair temp = pq.poll();
            long dis = temp.first;
            int node = temp.second;
            for(Pair itr : adj.get(node)){
                int adjNode = itr.second;
                long edW = itr.first;
                if(dis + edW < dist[adjNode]){
                    dist[adjNode] = dis + edW;
                    pq.offer(new Pair(dis + edW, adjNode));
                    ways[adjNode] = ways[node];
                }else if(dis + edW == dist[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n - 1] % mod;
    }
}
}
