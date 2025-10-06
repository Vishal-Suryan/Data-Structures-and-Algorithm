class Solution {
    static int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(nums, n - 1);
    }
    private static int helper(int[] nums, int idx){
        if(idx == 0) return nums[idx];
        if(idx < 0) return 0;
        if(dp[idx] != -1) return dp[idx];
        int pick = nums[idx] + helper(nums, idx - 2);
        int notPick = helper(nums, idx - 1);
        return dp[idx] = Math.max(pick, notPick);
    }
    public int rob1(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int idx = 2; idx < n; idx++){
            int pick = nums[idx] + dp[idx - 2];
            int notPick = dp[idx - 1];
            dp[idx] = Math.max(pick, notPick);
        }
        return dp[n - 1];
    }

    public int rob11(int[] nums) { // space optimized tabulation 
        int n = nums.length;
        if (n == 1) return nums[0];
        int prev1 = nums[0];
        int prev = Math.max(nums[0], nums[1]);
        for(int idx = 2; idx < n; idx++){
            int pick = nums[idx] + prev1;
            int notPick = prev;
            prev1 = prev;
            prev = Math.max(pick, notPick);
        }
        return prev;
    }
}