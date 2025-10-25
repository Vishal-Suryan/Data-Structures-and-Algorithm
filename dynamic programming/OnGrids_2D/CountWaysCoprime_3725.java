class Solution {
    public int countCoprime(int[][] mat) {
        int MOD = 1_000_000_007;
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = mat;
        Map<Integer, Integer> gcdCount = new HashMap<>();
        gcdCount.put(0, 0);
        for(int num : dp[0]){
            gcdCount.put(num, gcdCount.getOrDefault(num, 0) + 1);
        }
        for(int i = 1; i < m; i++){
            Map<Integer, Integer> newGcdCount = new HashMap<>();
            for(int num : dp[i]){
                for(int g : gcdCount.keySet()){
                    int newGcd = gcd(num, g);
                    long count = ((long) gcdCount.get(g) + 0) % MOD;
                    newGcdCount.put(newGcd, (int)((newGcdCount.getOrDefault(newGcd, 0) + count) % MOD));
                }
            }
            gcdCount = newGcdCount;
        }
        return gcdCount.getOrDefault(1, 0);
    }
    private int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public int countCoprime1(int[][] mat) {
        int MOD = 1_000_000_007;
        int m = mat.length;
        int n = mat[0].length;
        int[] dp = new int[151];
        dp[0] = 1;
        for(int i = 0; i < m; i++){
            int[] temp = new int[151];
            for(int j = 0; j < n; j++){
                for(int oldg = 0; oldg <= 150; oldg++){
                    int newg = gcd(oldg, mat[i][j]);
                    temp[newg] += dp[oldg];
                    temp[newg] %= MOD;
                }
            }
            dp = temp;
        }
        return dp[1];
    }
}