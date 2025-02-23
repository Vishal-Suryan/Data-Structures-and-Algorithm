import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class shortestPathinUDG {
    class Solution {
    // Function to find the shortest path from a source node to all other nodes
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        int n = adj.size();
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src,0));
        while(!q.isEmpty()){
            int node = q.peek().first;
            int distance = q.peek().second;
            q.poll();
            dist[node] = distance;
            for(int itr : adj.get(node)){
                if(dist[node] + 1 < dist[itr]) {
                    dist[itr] = 1 + dist[node]; 
                    q.offer(new Pair(itr,dist[itr])); 
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        return dist;
    }
    private class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
}
}
