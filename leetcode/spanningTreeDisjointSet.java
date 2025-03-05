import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class spanningTreeDisjointSet {
    class Solution {
    static class DisjointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();
        public DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                rank.add(0);
                parent.add(i);
                size.add(1);
            }
        }
    
        public int findUPar(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            int ulp = findUPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }
    
        public void unionByRank(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v) return;
            if (rank.get(ulp_u) < rank.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
            } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
                parent.set(ulp_v, ulp_u);
            } else {
                parent.set(ulp_v, ulp_u);
                int rankU = rank.get(ulp_u);
                rank.set(ulp_u, rankU + 1);
            }
        }
    
        public void unionBySize(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v) return;
            if (size.get(ulp_u) < size.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
            } else {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }
    }
    static class Edge implements Comparable<Edge>{
        int src, dest, wgt;
        Edge(int src, int dest, int wgt){
            this.src = src;
            this.dest = dest;
            this.wgt = wgt;
        }
        public int compareTo(Edge compareEdge){
            return this.wgt - compareEdge.wgt;
        }
    }
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int[] neighbor = adj.get(i).get(j); 
                int adjNode = neighbor[0];
                int wt = neighbor[1];
                edges.add(new Edge(i, adjNode, wt));
            }
        }
        DisjointSet ds = new DisjointSet(V);
        Collections.sort(edges);
        int mstWt = 0;
        for (int i = 0; i < edges.size(); i++) {
            int wt = edges.get(i).wgt;
            int u = edges.get(i).src;
            int v = edges.get(i).dest;
            if (ds.findUPar(u) != ds.findUPar(v)) {
                mstWt += wt;
                ds.unionBySize(u, v);
            }
        }
        return mstWt;
    }
}
}
