import java.util.*;
public class fibonacci {
    class Solution {
        private static int mod = 1000000007;
        static long topDown(int n) {
            // code here
            long[] dp = new long[n+1];
            Arrays.fill(dp, -1);
            return helper(n, dp);
    
        }
        private static long helper(int n, long[] dp){
            if(n == 0) return 0;
            if(n == 1) return 1;
            if(dp[n] != -1) return dp[n];
            return dp[n] = (helper(n-1, dp) + helper(n-2, dp)) % mod;
        }
    
        static long bottomUp(int n) {
            // code here
            if(n == 0) return 0;
            if(n == 1) return 1;
            long prev = 1 ;
            long prev2 = 0;
            for(int i = 2; i<= n; i++){
                long curi = (prev + prev2) % mod;
                prev2 = prev;
                prev = curi;
            }
            return prev;
        }
    }
}
