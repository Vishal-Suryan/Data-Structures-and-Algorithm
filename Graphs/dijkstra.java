import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class dijkstra {
    
class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}


// User function Template for Java
class Solution {
    // Function to find the shortest distance of all the vertices
    // from the source vertex src.
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        // Write your code here
        PriorityQueue<iPair> pq = new PriorityQueue<>((x,y)-> x.first - y.first);
        //int[] dist = new int[adj.size()];
        ArrayList<Integer> dist = new ArrayList<>(Collections.nCopies(adj.size(), Integer.MAX_VALUE));
        //dist[src] = 0;
        dist.set(src, 0);
        pq.offer(new iPair(0,src));
        while(!pq.isEmpty()){
            int distance = pq.peek().first;
            int node = pq.peek().second;
            pq.poll();
            for(iPair neighbour : adj.get(node)){
                int edgeWeight = neighbour.second;
                int adjNode = neighbour.first;
                if(distance + edgeWeight < dist.get(adjNode)){
                    dist.set(adjNode,distance + edgeWeight);
                    pq.offer(new iPair(dist.get(adjNode),adjNode));
                }
            }
        }
        return dist;
    }
}
}
