package DisjointSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mostStonesRemoves_947 {
    class Solution {
    public class DisjointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        DisjointSet(int n){
            for(int i = 0; i<=n; i++){
                rank.add(0);
                parent.add(i);
                size.add(1);
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

        public void unionBySize(int x, int y){
            int parentX = find(x);
            int parentY = find(y);
            if(parentX == parentY) return;
            if (size.get(parentX) < size.get(parentY)) { // Attaching smaller tree X to Y
                parent.set(parentX, parentY);
                size.set(parentY, size.get(parentY) + size.get(parentX));
            } else {
                parent.set(parentY, parentX); // Attaching smaller tree Y to X
                size.set(parentX, size.get(parentX) + size.get(parentY));
            }
        }
    }
    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        for(int  i = 0; i < stones.length; i++){
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] stone : stones) {
            int nodeRow = stone[0];
            int nodeCol = stone[1] + maxRow + 1; // Offset to avoid row-column collision
            ds.unionBySize(nodeRow, nodeCol);
            map.put(nodeRow, 1);
            map.put(nodeCol, 1);
        }
        int count = 0;
        for(Map.Entry<Integer,Integer> itr : map.entrySet()){
            if(ds.find(itr.getKey()) == itr.getKey()){
                count++;
            }
        }
        return stones.length - count;
    }
}
}
