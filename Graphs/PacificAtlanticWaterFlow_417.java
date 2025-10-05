class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for(int i = 0; i < m; i++){
            dfs(pacific, i, 0, m, n, heights);
            dfs(atlantic, i, n - 1, m, n, heights);
        }
        for(int i = 0; i < n; i++){
            dfs(pacific, 0, i, m, n, heights);
            dfs(atlantic, m - 1, i, m, n, heights);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }
    private void dfs(boolean[][] visited, int x, int y, int m, int n, int[][] heights){
        visited[x][y] = true;
        for(int[] dir : dirs){
            int nx = x + dir[0];
            int ny = y + dir[1];
            if(nx < 0 || ny < 0 || nx >= m || ny >= n 
            || visited[nx][ny] || heights[nx][ny] < heights[x][y]) continue;
            dfs(visited, nx, ny, m, n, heights);
        }
        return;
    }
}