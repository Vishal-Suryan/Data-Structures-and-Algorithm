import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class networkDelayTime {
    class Solution {
    class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] time : times){
            int from = time[0];
            int to = time[1];
            int price = time[2];
            adj.get(from).add(new Pair(to,price));
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Pair> q = new LinkedList<>();
        dist[k] = 0;
        q.offer(new Pair(k,0));
        while(!q.isEmpty()){
            Pair current = q.poll();
            int node = current.first;
            int currentTime = current.second;
            for(Pair itr : adj.get(node)){
                int adjNode = itr.first;
                int travelTime = itr.second;
                if (currentTime + travelTime < dist[adjNode]) {
                    dist[adjNode] = currentTime + travelTime;
                    q.offer(new Pair(adjNode, dist[adjNode]));
                }
            }
        }
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; 
            }
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;
    }
}
}
