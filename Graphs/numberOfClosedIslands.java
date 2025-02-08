public class numberOfClosedIslands {
    class Solution {
        public int closedIsland(int[][] grid) {
            int m=grid.length;
            int n=grid[0].length;
            for(int i=0;i<m;i++){
                if(grid[i][0]==0){
                    dfs(grid,i,0,m,n);
                }
                if(grid[i][n-1]==0){
                    dfs(grid,i,n-1,m,n);
                }
            }
            for(int i=0;i<n;i++){
                if(grid[0][i]==0){
                    dfs(grid,0,i,m,n);
                }
                if(grid[m-1][i]==0){
                    dfs(grid,m-1,i,m,n);
                }
            }
            int res=0;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j]==0){
                        res++;
                        dfs(grid,i,j,m,n);
                    }
                }
            }
            return res;
        }
        private void dfs(int[][] grid,int i,int j,int m,int n){
            grid[i][j]=1;
            int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
            for(int k=0;k<4;k++){
                int newi=i+dir[k][0];
                int newj=j+dir[k][1];
                if(isSafe(newi,newj,m,n) && grid[newi][newj]==0){
                    dfs(grid,newi,newj,m,n);
                }
            }
        }
        private boolean isSafe(int i,int j,int m,int n){
            return (i>=0 && i<m && j>=0 && j<n );
        }
    }
}
