public class numberOfEnclaves {
    class Solution {
        class Pair{
            int first;
            int second;
            public Pair(int first, int second){
                this.first=first;
                this.second=second;
            }
        }
        private boolean isSafe(int r, int c, int m, int n){
            return (r>=0 && r<m && c>=0 && c<n);
        }
        public int numEnclaves(int[][] grid) {
            int m=grid.length;
            int n=grid[0].length;
            int[][] vis = new int[m][n];
            for(int i=0;i<n;i++){
                if(grid[0][i]==1){
                    dfs(grid,0,i,m,n,vis);
                }
                if(grid[m-1][i]==1){
                    dfs(grid,m-1,i,m,n,vis);
                }
            }
            for(int i=0;i<m;i++){
                if(grid[i][0]==1){
                    dfs(grid,i,0,m,n,vis);
                }
                if(grid[i][n-1]==1){
                    dfs(grid,i,n-1,m,n,vis);
                }
            }
            int cnt = 0;
            for(int i = 0;i<m;i++) {
                for(int j = 0;j<n;j++) {
                    if(grid[i][j] == 1 & vis[i][j] == 0) 
                        cnt++; 
                }
            }
            return cnt;
        }
        private void dfs( int[][] grid, int r, int c, int m, int n, int[][] vis){
            vis[r][c]=1;
            int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
            for(int i = 0; i<4; i++){
                int newr = r + dir[i][0];
                int newc = c + dir[i][1];
                if(isSafe(newr,newc,m,n) && grid[newr][newc]==1 && vis[newr][newc]==0){
                    dfs(grid,newr,newc,m,n,vis);
                }
            }
        }
    }
}
