class Solution {
    int[][] dp;
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        int sum = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            sum = Math.min(sum, helper(0, i, n, matrix));
        }
        return sum;
    }
    private int helper(int x, int y, int n, int[][] matrix){
        if(x == n - 1){
            return matrix[x][y];
        }
        if(dp[x][y] != Integer.MAX_VALUE) return dp[x][y];
        int dLeft = (y - 1 >= 0) ? helper(x + 1, y - 1, n, matrix) : Integer.MAX_VALUE; 
        int d = (x + 1 < n) ? helper(x + 1, y, n, matrix) : Integer.MAX_VALUE; 
        int dRight = (y + 1 < n) ? helper(x + 1, y + 1, n, matrix) : Integer.MAX_VALUE;
        return dp[x][y] = matrix[x][y] + Math.min(dLeft, Math.min(d, dRight)); 
    }
    public int minFallingPathSum1(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            dp[n - 1][i] = matrix[n - 1][i];
        }
        for(int i = n - 2; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                int dLeft = (j - 1 >= 0) ? dp[i + 1][j - 1] : Integer.MAX_VALUE; 
                int d = dp[i + 1][j]; 
                int dRight = (j + 1 < n) ? dp[i + 1][j + 1] : Integer.MAX_VALUE;
                dp[i][j] = matrix[i][j] + Math.min(dLeft, Math.min(d, dRight));
            }
        }
        int sum = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            sum = Math.min(sum, dp[0][i]);
        }
        return sum;
    }
    public int minFallingPathSum2(int[][] matrix) {
        int n = matrix.length;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = matrix[n - 1][i];
        }
        for(int i = n - 2; i >= 0; i--){
            int downLeft = Integer.MAX_VALUE;
            for(int j = 0; j < n; j++){
                //int dLeft = (j - 1 >= 0) ? dp[j - 1] : Integer.MAX_VALUE; 
                int d = dp[j]; 
                int dRight = (j + 1 < n) ? dp[j + 1] : Integer.MAX_VALUE;
                dp[j] = matrix[i][j] + Math.min(downLeft, Math.min(d, dRight));
                downLeft = d;
            }
        }
        int sum = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            sum = Math.min(sum, dp[i]);
        }
        return sum;
    }
}