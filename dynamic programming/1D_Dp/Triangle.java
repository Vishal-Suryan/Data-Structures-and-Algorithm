//LC 120
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] memo = new Integer[n][n]; // memoization table
        return dfs(triangle, 0, 0, memo);
    }
    private int dfs(List<List<Integer>> triangle, int row, int col, Integer[][] memo) {
        if(row == triangle.size() - 1){
            return triangle.get(row).get(col);
        }
        if(memo[row][col] != null) return memo[row][col];
        int down = dfs(triangle, row + 1, col, memo);
        int diag = dfs(triangle, row + 1, col + 1, memo);
        memo[row][col] = triangle.get(row).get(col) + Math.min(down, diag);
        return memo[row][col];
    }
    // tabulation method
    public int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();
        // Copy the last row as starting dp state
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }
        // Build from bottom-1 row up to row 0
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
            }
        }
        return dp[0];
    }
}