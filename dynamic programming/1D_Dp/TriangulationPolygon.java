class Solution { // LC 1039
    int[][] dp;
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        dp = new int[n][n]; 
        return solve(values, 0, n - 1);
    }
    private int solve(int[] values, int i, int j){
        if(j - i + 1 < 3) return 0;
        if(dp[i][j] != 0) return dp[i][j];
        int result = Integer.MAX_VALUE;
        for(int k = i + 1; k < j; k++){
            int wt = values[i] * values[j] * values[k] + 
            solve(values, i, k) + 
            solve(values, k, j);
            result = Math.min(result, wt);
        }
        return dp[i][j] = result;
    }
}