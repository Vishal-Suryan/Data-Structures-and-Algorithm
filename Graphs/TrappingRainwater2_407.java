class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        if(m < 3 || n < 3) return 0;
        boolean[][] vis = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        for(int i = 0; i < m; i++){
            pq.offer(new int[]{heightMap[i][0], i, 0});
            pq.offer(new int[]{heightMap[i][n - 1], i, n - 1});
            vis[i][0] = vis[i][n - 1] = true;
        }
        for(int j = 1; j < n - 1; j++){
            pq.offer(new int[]{heightMap[0][j], 0, j});
            pq.offer(new int[]{heightMap[m - 1][j], m - 1, j});
            vis[0][j] = vis[m - 1][j] = true;
        }
        int trapped = 0;
        int[][] dir = {{1,0}, {-1,0}, {0, 1}, {0, -1}};
        while(!pq.isEmpty()){
            int[] cell = pq.poll();
            int height = cell[0], x = cell[1], y = cell[2];
            for(int[] d : dir){
                int newX = x + d[0];
                int newY = y + d[1];
                if(newX < 0 || newY < 0 || newX >= m || newY >= n || vis[newX][newY]) continue;
                vis[newX][newY] = true;
                trapped += Math.max(0, height - heightMap[newX][newY]);
                pq.offer(new int[]{Math.max(height, heightMap[newX][newY]), newX, newY});
            }
        }
        return trapped;
    }
}