public class climbingStairs_70 {
    class Solution {
        public int climbStairs(int n) {
            if(n == 1) return 1;
            int prev = 2;
            int prev2 = 1;
            for(int i = 3; i<=n; i++){
                int curi = prev + prev2;
                prev2 = prev;
                prev = curi;
            }
            return prev;
        }
    }
}
