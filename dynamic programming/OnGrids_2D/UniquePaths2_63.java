class Solution {
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        dp = new int[m][n];
        return helper(0, 0, m, n, obstacleGrid);
    }
    private int helper(int x, int y, int m, int n, int[][] obstacleGrid){
        if(x >= m || y >= n || obstacleGrid[x][y] == 1) return 0;
        if(x == m - 1 && y == n - 1){
            return 1;
        } 
        if(dp[x][y] != 0) return dp[x][y];
        int right = helper(x, y + 1, m, n, obstacleGrid);
        int down = helper(x + 1, y, m, n, obstacleGrid);
        dp[x][y] = right + down;
        return dp[x][y];
    }
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m - 1][n - 1] == 1) return 0;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 1;
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                if(i == m - 1 && j == n - 1) continue;
                int down = (i + 1 < m)? dp[i + 1][j] : 0;
                int right = (j + 1 < n)? dp[i][j + 1] : 0;
                dp[i][j] = down + right;
            }
        }
        return dp[0][0];
    }
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m - 1][n - 1] == 1) return 0;
        int[] next = new int[n];
        next[n - 1] = (obstacleGrid[m - 1][n - 1] == 1) ? 0 : 1;
        for(int i = m - 1; i >= 0; i--){
            int[] curr = new int[n];
            for(int j = n - 1; j >= 0; j--){
                if(obstacleGrid[i][j] == 1){
                    curr[j] = 0;
                    continue;
                }
                if(i == m - 1 && j == n - 1){
                    curr[j] = 1;
                    continue;
                }
                int right = (j + 1 < n) ? curr[j + 1] : 0;
                int down = (i + 1 < m) ? next[j] : 0;
                curr[j] = right + down;
            }
            next = curr;
        }
        return next[0];
    }
    public int uniquePathsWithObstacles3(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m - 1][n - 1] == 1) return 0;
        int[] dp = new int[n];
        dp[n - 1] = (obstacleGrid[m - 1][n - 1] == 1) ? 0 : 1;
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(obstacleGrid[i][j] == 1){
                    dp[j] = 0;
                    continue;
                }
                if(i == m - 1 && j == n - 1) continue;
                int right = (j + 1 < n) ? dp[j + 1] : 0;
                int down = (i + 1 < m) ? dp[j] : 0;
                dp[j] = right + down;
            }
        }
        return dp[0];
    }
}