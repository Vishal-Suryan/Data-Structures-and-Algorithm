import java.util.LinkedList;
import java.util.Queue;

public class shortestPathinBinaryMatrix {
    class Solution {
    class Pair{
        int row;
        int col;
        int dist;
        Pair(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;
        boolean[][] vis = new boolean[n][n];
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0,1));
        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
        vis[0][0] = true;
        while(!q.isEmpty()){
            Pair node = q.poll();
            int r = node.row;
            int c = node.col;
            int dist = node.dist;
            if(r == n-1 && c == n-1) return dist;
            for(int i = 0; i<8; i++){
                int newr = r + dir[i][0];
                int newc = c + dir[i][1];
                if(isSafe(newr, newc, n) && grid[newr][newc] == 0 && !vis[newr][newc]){
                    vis[newr][newc] = true;
                    q.offer(new Pair(newr, newc, dist + 1));
                }
            }
        }
        return -1;
    }
    private boolean isSafe(int r, int c, int n){
        return (r>=0 && r<n && c>=0 && c<n);
    }
}
}
