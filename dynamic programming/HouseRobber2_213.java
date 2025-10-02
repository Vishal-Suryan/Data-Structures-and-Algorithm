class Solution {
    public int rob1(int[] nums ,int start, int end) {
        int prev1 = 0;
        int prev = 0;
        for(int idx = start; idx <= end; idx++){
            int pick = nums[idx] + prev1;
            int notPick = prev;
            prev1 = prev;
            prev = Math.max(pick, notPick);
        }
        return prev;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int case1 = rob1(nums, 0, n - 2);
        int case2 = rob1(nums, 1, n - 1);
        return Math.max(case1, case2);
    }
}