import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class cheapestFlightWithinKstops {
    class Solution {
    class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    class Tuple {
        int first, second, third; 
        Tuple(int first, int second, int third) {
            this.first = first; 
            this.second = second;
            this.third = third; 
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] flight : flights){
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            adj.get(from).add(new Pair(to,price));
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(0, src, 0));
        while(!q.isEmpty()){
            Tuple temp = q.poll();
            int stops = temp.first;
            int node = temp.second;
            int cost = temp.third;
            if(stops > k) continue;
            for(Pair itr : adj.get(node)){
                int adjNode = itr.first; 
                int price = itr.second; 
                if (cost + price < dist[adjNode] && stops <= k) {
                    dist[adjNode] = cost + price; 
                    q.add(new Tuple(stops + 1, adjNode, cost + price)); 
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}
}
