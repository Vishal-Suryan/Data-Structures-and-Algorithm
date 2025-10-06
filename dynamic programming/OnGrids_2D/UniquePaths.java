class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        return helper(0, 0, m, n);
    }
    private int helper(int x, int y, int m, int n){
        if(x == m - 1 && y == n - 1){
            return 1;
        } 
        if(x >= m || y >= n) return 0;
        if(dp[x][y] != 0) return dp[x][y];

        int right = helper(x, y + 1, m, n);
        int down = helper(x + 1, y, m, n);
        dp[x][y] = right + down;
        return dp[x][y];
    }
    public int uniquePaths1(int m, int n) { // Bottom - Up -- Tabulation
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 1;
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(i == m - 1 && j == n - 1) continue;
                int down = (i + 1 < m)? dp[i + 1][j] : 0;
                int right = (j + 1 < n)? dp[i][j + 1] : 0;
                dp[i][j] = down + right;
            }
        }
        return dp[0][0];
    }
    public int uniquePaths2(int m, int n) { // Space optimized - 2 - 1D array
        int[] next = new int[n]; //  represents the bottom-most row
        Arrays.fill(next, 1);
        for(int i = m - 2; i >= 0; i--){
            int[] curr = new int[n];
            for(int j = n - 1; j >= 0; j--){
                if(j == n - 1){
                    curr[j] = 1; // last column → only one way (down)
                }else{
                    curr[j] = curr[j + 1] + next[j]; // right + down
                }
            }
            next = curr; // move up
        }

        return next[0];
    }
    public int uniquePaths3(int m, int n) { // Space optimized - 1 - 1D array
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = m - 2; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--){
                dp[j] = dp[j] + dp[j + 1];
            }
        }
        return dp[0];
    }
}