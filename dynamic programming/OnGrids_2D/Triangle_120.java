class Solution {
    int[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        dp = new int[n][n];
        for(int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        return helper(triangle, 0, 0);
    }
    private int helper(List<List<Integer>> triangle, int i, int j){
        int n = triangle.size();
        if(i == n - 1) return triangle.get(i).get(j);
        if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        int down = triangle.get(i).get(j) + helper(triangle, i + 1, j);
        int diagonal = triangle.get(i).get(j) + helper(triangle, i + 1, j + 1);
        return dp[i][j] = Math.min(down, diagonal);
    }
    public int minimumTotal1(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[] dp = new int[m];
        for(int j = m - 1; j >= 0; j--){
            dp[j] = triangle.get(m - 1).get(j);
        }
        for(int i = m - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }
}