class Solution {
    static int[][] dp;
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        dp = new int[n][sum + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(n - 1, arr, sum);
    }
    static boolean helper(int n, int[] arr, int target){
        if(target == 0) return true;
        if(n == 0) return arr[n] == target;
        if(dp[n][target] != -1){
            return dp[n][target] == 0 ? false : true;
        }
        boolean notTake = helper(n - 1, arr, target);
        boolean take = false;
        if(arr[n] <= target){
            take = helper(n - 1, arr, target - arr[n]);
        }
        dp[n][target] = (notTake || take) ? 1 : 0;
        return notTake || take;
    }
    static Boolean isSubsetSum1(int arr[], int sum) {
        // code here
        int n = arr.length;
        boolean[][] dp = new boolean[n][sum + 1];
        for(int i = 0; i < n; i++){
            dp[i][0] = true;
        }
        if(arr[0] <= sum) {
            dp[0][arr[0]] = true;
        }
        for(int i = 1; i < n; i++){
            for(int target = 1; target <= sum; target++){
                boolean notTake = dp[i - 1][target];
                boolean take = false;
                if(arr[i] <= target){
                    take = dp[i - 1][target - arr[i]];
                }
                dp[i][target] = notTake || take;
            }
        }
        return dp[n - 1][sum];
    }
    static Boolean isSubsetSum2(int arr[], int sum) {
        // code here
        int n = arr.length;
        boolean[] prev = new boolean[sum + 1];
        prev[0] = true;
        if(arr[0] <= sum) {
            prev[arr[0]] = true;
        }
        for(int i = 1; i < n; i++){
            boolean[] curr = new boolean[sum + 1];
            curr[0] = true;
            for(int target = 1; target <= sum; target++){
                boolean notTake = prev[target];
                boolean take = false;
                if(arr[i] <= target){
                    take = prev[target - arr[i]];
                }
                curr[target] = notTake || take;
            }
            prev = curr;
        }
        return prev[sum];
    }
}