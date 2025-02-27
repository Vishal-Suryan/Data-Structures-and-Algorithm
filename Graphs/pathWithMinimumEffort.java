import java.util.*;
public class pathWithMinimumEffort {
    class Solution {
        class Pair{
            int diff;
            int row;
            int col;
            Pair(int diff, int row, int col){
                this.diff = diff;
                this.row = row;
                this.col = col;
            }
        }
        private boolean isSafe(int r, int c, int m, int n){
            return (r >= 0 && r < m && c >=0 && c < n);
        }
        public int minimumEffortPath(int[][] heights) {
            int m = heights.length;
            int n = heights[0].length;
            PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.diff - y.diff);
            int[][] dist = new int[m][n];
            for(int[] dis : dist){
                Arrays.fill(dis, Integer.MAX_VALUE);
            }
            dist[0][0] = 0;
            pq.offer(new Pair(0,0,0));
            int[][] dir = { {0,1}, {0,-1}, {1,0}, {-1,0} };
            while(!pq.isEmpty()){
                Pair node = pq.poll();
                int distance = node.diff;
                int row = node.row;
                int col = node.col;
                if (row == m - 1 && col == n - 1) return distance;
                for(int i = 0; i<4; i++){
                    int newr = row + dir[i][0];
                    int newc = col + dir[i][1];
                    if(isSafe(newr, newc, m, n)){
                        int difference = Math.max(distance, 
                        Math.abs(heights[newr][newc] - heights[row][col]));
                        if(dist[newr][newc] > difference){
                            dist[newr][newc] = difference;
                            pq.offer(new Pair(dist[newr][newc], newr, newc));
                        }
                    }
                }
            }
            return 0;
        }
    }
}
