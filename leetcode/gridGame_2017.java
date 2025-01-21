public class gridGame_2017 {
    class Solution {
        public long gridGame(int[][] grid) {
            long firstRowSum=0;
            for(int num:grid[0]){
                firstRowSum+=num;
            }
            long secondRowSum=0;
            long min=Long.MAX_VALUE;
            for(int i=0;i<grid[0].length;i++){
                firstRowSum -=grid[0][i];
                min=Math.min(min,Math.max(firstRowSum,secondRowSum));
                secondRowSum+=grid[1][i];
            }
            return min;
        }
    }
}
