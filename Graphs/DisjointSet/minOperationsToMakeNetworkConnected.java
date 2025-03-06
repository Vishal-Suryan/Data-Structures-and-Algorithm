package DisjointSet;

import java.util.ArrayList;
import java.util.List;

public class minOperationsToMakeNetworkConnected {
    class Solution {
    public class DisjointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        DisjointSet(int n){
            for(int i = 0; i<=n; i++){
                rank.add(0);
                parent.add(i);
            }
        }
        public int find(int node){
            if(node == parent.get(node)){
                return node;
            }
            int ultimateParent = find(parent.get(node));
            parent.set(node,ultimateParent);
            return parent.get(node);
        }
        public void unionByRank(int x , int y){
            int parentX = find(x);
            int parentY = find(y);
            if(parentX == parentY) return;
            if(rank.get(parentX) < rank.get(parentY)){ 
                parent.set(parentX,parentY);
            }else if(rank.get(parentY) < rank.get(parentX)){  
                parent.set(parentY, parentX);
            }else{
                parent.set(parentY, parentX);
                int rankX = rank.get(parentX);
                rank.set(parentX, rankX + 1);
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extra = 0;
        int m = connections.length;
        for(int i = 0; i<m; i++){
            int u = connections[i][0];
            int v = connections[i][1];
            if(ds.find(u) == ds.find(v)){
                extra++;
            }else{
                ds.unionByRank(u, v);
            }
        }
        int count = 0;
        for(int i = 0; i<n; i++){
            if(ds.parent.get(i) == i){
                count++;
            }
        }
        int ans = count - 1;
        if(extra >= ans) return ans;
        return -1;
    }
}
}
