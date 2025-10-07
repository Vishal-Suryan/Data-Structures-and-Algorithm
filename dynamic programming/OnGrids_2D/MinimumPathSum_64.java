class Solution {
    int[][] dp;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];
        return helper(0, 0, m, n, grid);
    }
    private int helper(int x, int y, int m, int n, int[][] grid){
        if(x == m - 1 && y == n - 1) return grid[x][y];
        if(dp[x][y] != 0) return dp[x][y];
        int right = (y + 1 < n) ? grid[x][y] + helper(x, y + 1, m, n, grid) : Integer.MAX_VALUE;
        int down = (x + 1 < m) ? grid[x][y] + helper(x + 1, y, m, n, grid) : Integer.MAX_VALUE;
        dp[x][y] = Math.min(right, down);
        return dp[x][y];
    }
    public int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = grid[m - 1][n - 1];
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(i == m - 1 && j == n - 1) continue;
                int right = (j + 1 < n) ? grid[i][j] + dp[i][j + 1] : Integer.MAX_VALUE;
                int down = (i + 1 < m) ? grid[i][j] + dp[i + 1][j] : Integer.MAX_VALUE;
                dp[i][j] = Math.min(right, down);
            }
        }
        return dp[0][0];
    }
    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] next = new int[n];
        for(int i = m - 1; i >= 0; i--){
            int[] curr = new int[n];
            for(int j = n - 1; j >= 0; j--){
                if(i == m - 1 && j == n - 1){
                    curr[j] = grid[i][j];
                    continue;
                } 
                int right = (j + 1 < n) ? grid[i][j] + curr[j + 1] : Integer.MAX_VALUE;
                int down = (i + 1 < m) ? grid[i][j] + next[j] : Integer.MAX_VALUE;
                curr[j] = Math.min(right, down);
            }
            next = curr;
        }
        return next[0];
    }
    public int minPathSum3(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        for(int j = n - 1; j >= 0; j--){
            if(j == n - 1){
                dp[j] = grid[m - 1][j];
            }else{
                dp[j] = grid[m - 1][j] + dp[j + 1];
            }
        }
        for(int i = m - 2; i >= 0; i--){
            dp[n - 1] += grid[i][n - 1];
            for(int j = n - 2; j >= 0; j--){
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }
}