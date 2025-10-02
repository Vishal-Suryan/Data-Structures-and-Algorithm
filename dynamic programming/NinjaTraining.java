class Solution {
    int[][] dp;
    public int maximumPoints(int arr[][]) {
        // code here
        int n = arr.length;
        dp = new int[n][4];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        return helper(arr, n - 1, 3);
    }
    private int helper(int[][] arr, int day, int last){
        if(dp[day][last] != -1) return dp[day][last];
        if(day == 0){
            int max = 0;
            for(int i = 0; i < 3; i++){
                if(i != last){
                    max = Math.max(max, arr[day][i]);
                }
            }
            return dp[day][last] = max;
        }
        int max = 0;
        for(int i = 0; i < 3; i++){
            if(last != i){
                int points = arr[day][i] + helper(arr, day - 1, i);
                max = Math.max(max, points);
            }
        }
        return dp[day][last] = max;
    }
    public int maximumPoints1(int arr[][]) { // tabulation
        // code here
        int n = arr.length;
        int[][] dp = new int[n][4];
        for(int last = 0; last < 4; last++){
            int max = 0;
            for(int task = 0; task < 3; task++){
                if(task != last){
                    max = Math.max(max, arr[0][task]);
                }
            }
            dp[0][last] = max;
        }
        for(int day = 1; day < n; day++){
            for(int last = 0; last < 4; last++){
                int max = 0;
                for(int task = 0; task < 3; task++){
                    if(task != last){
                        int points = arr[day][task] + dp[day - 1][task];
                        max = Math.max(max, points);
                    }
                }
                dp[day][last] = max;
            }
        }
        return dp[n-1][3];
    }
        public int maximumPoints2(int arr[][]) { // Space optimized tabulation
        // code here
        int n = arr.length;
        int[] prev = new int[4];
        for(int last = 0; last < 4; last++){
            int max = 0;
            for(int task = 0; task < 3; task++){
                if(task != last){
                    max = Math.max(max, arr[0][task]);
                }
            }
            prev[last] = max;
        }
        for(int day = 1; day < n; day++){
            int[] curr = new int[4];
            for(int last = 0; last < 4; last++){
                int max = 0;
                for(int task = 0; task < 3; task++){
                    if(task != last){
                        int points = arr[day][task] + prev[task];
                        max = Math.max(max, points);
                    }
                }
                curr[last] = max;
            }
            prev = curr;
        }
        return prev[3];
    }
}