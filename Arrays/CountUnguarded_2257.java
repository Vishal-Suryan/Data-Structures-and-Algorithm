class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for(int[] wall : walls){
            grid[wall[0]][wall[1]] = 3;
        }
        for(int[] guard : guards){
            grid[guard[0]][guard[1]] = 2;
        }
        for(int[] guard : guards){
            int r = guard[0], c = guard[1];
            for(int i = r - 1; i >= 0 && grid[i][c] != 3 && grid[i][c] != 2; i--){
                if (grid[i][c] == 0) grid[i][c] = 1;
            }
            // down
            for(int i = r + 1; i < m && grid[i][c] != 3 && grid[i][c] != 2; i++){
                if (grid[i][c] == 0) grid[i][c] = 1;
            }

            // left
            for(int j = c - 1; j >= 0 && grid[r][j] != 3 && grid[r][j] != 2; j--){
                if (grid[r][j] == 0) grid[r][j] = 1;
            }

            // right
            for(int j = c + 1; j < n && grid[r][j] != 3 && grid[r][j] != 2; j++){
                if (grid[r][j] == 0) grid[r][j] = 1;
            }
        }
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) count++;
            }
        }
        return count;
    }
}