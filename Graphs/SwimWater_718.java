class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dirs = {{0,1}, {1,0}, {-1, 0}, {0, -1}};
        boolean[][] vis = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0], 0, 0});
        int res = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int ht = curr[0];
            int x = curr[1], y = curr[2];
            res = Math.max(ht, res);
            if(x == n - 1 && y == n - 1) return res;
            if(vis[x][y]) continue;
            vis[x][y] = true;
            for(int[] dir : dirs){
                int nx = x + dir[0];
                int ny = y + dir[1];
                if(nx >= 0 && ny >= 0 && nx < n && ny < n && !vis[nx][ny]){
                    pq.offer(new int[]{grid[nx][ny], nx, ny});
                }
            }
        }
        return -1;
    }
}