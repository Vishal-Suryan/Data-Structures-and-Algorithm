class Solution {
    public boolean canPartition(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for(int num : arr) sum += num;
        if (sum % 2 != 0) return false;
        sum /= 2;
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