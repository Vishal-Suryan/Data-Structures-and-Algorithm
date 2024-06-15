
public class mobileNumeric {
    class Solution {
        public long getCount(int n) {
            // Your code goes here
            if (n == 1) return 10; // Base case: if n is 1, there are 10 single-digit numbers.
    
            // Define the keypad moves.
            int[][] moves = {
                {0, 8},    // moves for 0
                {1, 2, 4}, // moves for 1
                {2, 1, 3, 5}, // moves for 2
                {3, 2, 6}, // moves for 3
                {4, 1, 5, 7}, // moves for 4
                {5, 2, 4, 6, 8}, // moves for 5
                {6, 3, 5, 9}, // moves for 6
                {7, 4, 8}, // moves for 7
                {8, 0, 5, 7, 9}, // moves for 8
                {9, 6, 8} // moves for 9
            };
    
            // Initialize the DP table.
            long[][] dp = new long[n + 1][10];
    
            // Base case: sequences of length 1
            for (int i = 0; i < 10; i++) {
                dp[1][i] = 1;
            }
    
            // Fill the DP table for sequences of length 2 to n
            for (int len = 2; len <= n; len++) {
                for (int digit = 0; digit < 10; digit++) {
                    dp[len][digit] = 0;
                    for (int move : moves[digit]) {
                        dp[len][digit] += dp[len - 1][move];
                    }
                }
            }
    
            // Sum up all sequences of length n
            long totalSequences = 0;
            for (int i = 0; i < 10; i++) {
                totalSequences += dp[n][i];
            }
    
            return totalSequences;
        }
    }
}
