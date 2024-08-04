public class weeklyContest409_Q1 {
    class neighborSum {
        private int[][] grid;
        private int n;
        private int[][] positionMap;
        public neighborSum(int[][] grid) {
            this.grid = grid;
            this.n = grid.length;
            this.positionMap = new int[n * n][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    positionMap[grid[i][j]][0] = i;
                    positionMap[grid[i][j]][1] = j;
                }
            }
        }
        
        public int adjacentSum(int value) {
            int[] pos = positionMap[value];
            int i = pos[0], j = pos[1];
            int sum = 0;
            if (i > 0) sum += grid[i - 1][j];
            if (i < n - 1) sum += grid[i + 1][j];
            if (j > 0) sum += grid[i][j - 1];
            if (j < n - 1) sum += grid[i][j + 1];
            return sum;
        }
        
        public int diagonalSum(int value) {
            int[] pos = positionMap[value];
            int i = pos[0], j = pos[1];
            int sum = 0;
            if (i > 0 && j > 0) sum += grid[i - 1][j - 1];
            if (i > 0 && j < n - 1) sum += grid[i - 1][j + 1];
            if (i < n - 1 && j > 0) sum += grid[i + 1][j - 1];
            if (i < n - 1 && j < n - 1) sum += grid[i + 1][j + 1];
            return sum;
        }
    }
    
    /**
     * Your neighborSum object will be instantiated and called as such:
     * neighborSum obj = new neighborSum(grid);
     * int param_1 = obj.adjacentSum(value);
     * int param_2 = obj.diagonalSum(value);
     */
}
