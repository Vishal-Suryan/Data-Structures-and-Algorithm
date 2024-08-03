public class biweekly136_Q2 {
    class Solution {
        static int minFlipsToMakePalindrome(int[] array) {
            int flips = 0;
            int start = 0;
            int end = array.length - 1;
            while (start < end) {
                if (array[start] != array[end]) {
                    flips++;
                }
                start++;
                end--;
            }
            return flips;
        }
        
        public int minFlips(int[][] grid) {
            int rowFlips = 0;
            int colFlips = 0;
            
            for (int[] row : grid) {
                rowFlips += minFlipsToMakePalindrome(row);
            }
            
            for (int col = 0; col < grid[0].length; col++) {
                int[] column = new int[grid.length];
                for (int row = 0; row < grid.length; row++) {
                    column[row] = grid[row][col];
                }
                colFlips += minFlipsToMakePalindrome(column);
            }
            
            return Math.min(rowFlips, colFlips);
        }
    }
    
}
