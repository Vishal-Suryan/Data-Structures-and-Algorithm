class Solution {
    int[][][] dp;
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n][m][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return helper(0, 0, m - 1, n, m, grid);
    }
    private int helper(int x, int y1, int y2, int n, int m, int[][] grid){
        if(y1 < 0 || y2 < 0 || y1 >= m || y2 >= m) return (int) -1e8;
        if(x == n - 1){
            return (y1 == y2) ? grid[x][y1] : grid[x][y1] + grid[x][y2];
        }
        if(dp[x][y1][y2] != -1) return dp[x][y1][y2];
        int max = 0;
        for(int dy1 = -1; dy1 <= 1; dy1++){
            for(int dy2 = -1; dy2 <= 1; dy2++){
                if(y1 == y2){
                    max = Math.max(max, grid[x][y1] + helper(x + 1, y1 + dy1, y2 + dy2, n, m, grid));
                }else{
                    max = Math.max(max, grid[x][y1] + grid[x][y2]
                    + helper(x + 1, y1 + dy1, y2 + dy2, n, m, grid));
                }
            }
        }
        dp[x][y1][y2] = max;
        return max;
    }
    public int cherryPickup1(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];
        for(int j1 = 0; j1 < m; j1++){
            for(int j2 = 0; j2 < m; j2++){
                dp[n - 1][j1][j2] = (j1 == j2) ? grid[n - 1][j1] : grid[n - 1][j1] + grid[n - 1][j2];
            }
        }
        for(int i = n - 2; i >= 0; i--){
            for(int j1 = 0; j1 < m; j1++){
                for(int j2 = 0; j2 < m; j2++){
                    int max = 0;
                    for(int dy1 = -1; dy1 <= 1; dy1++){
                        for(int dy2 = -1; dy2 <= 1; dy2++){
                            int ny1 = j1 + dy1;
                            int ny2 = j2 + dy2;
                            if(ny1 >= 0 && ny1 < m && ny2 >= 0 && ny2 < m){
                                int val = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
                                max = Math.max(max, val + dp[i + 1][ny1][ny2]);
                            }
                        }
                    }
                    dp[i][j1][j2] = max;
                }
            }
        }
        return dp[0][0][m - 1];
    }
    public int cherryPickup2(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[m][m];
        for(int j1 = 0; j1 < m; j1++){
            for(int j2 = 0; j2 < m; j2++){
                dp[j1][j2] = (j1 == j2) ? grid[n - 1][j1] : grid[n - 1][j1] + grid[n - 1][j2];
            }
        }
        for(int i = n - 2; i >= 0; i--){
            int[][] curr = new int[m][m];
            for(int j1 = 0; j1 < m; j1++){
                for(int j2 = 0; j2 < m; j2++){
                    int max = 0;
                    for(int dy1 = -1; dy1 <= 1; dy1++){
                        for(int dy2 = -1; dy2 <= 1; dy2++){
                            int ny1 = j1 + dy1;
                            int ny2 = j2 + dy2;
                            if(ny1 >= 0 && ny1 < m && ny2 >= 0 && ny2 < m){
                                int val = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
                                max = Math.max(max, val + dp[ny1][ny2]);
                            }
                        }
                    }
                    curr[j1][j2] = max;
                }
            }
            dp = curr;
        }
        return dp[0][m - 1];
    }
}