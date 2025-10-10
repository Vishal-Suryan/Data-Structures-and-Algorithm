class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < energy.length; i++){
            int curr = energy[i];
            for(int j = i + k; j < energy.length; j++){
                curr += energy[j];
                j += k - 1;
            } 
            max = Math.max(max, curr);
        }
        return max;
    }
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i = n - 1; i >= 0; i--){
            if(i + k < n){
                dp[i] = energy[i] + dp[i + k];
            }else{
                dp[i] = energy[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}