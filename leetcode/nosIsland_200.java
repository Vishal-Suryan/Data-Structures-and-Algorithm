import java.util.LinkedList;
import java.util.Queue;

public class nosIsland_200 {
    class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first=first;
            this.second=second;
        }
    }
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] vis=new boolean[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    count++;
                    //dfs(grid,vis,i,j,m,n);
                    Queue<Pair> q=new LinkedList<>();
                    q.offer(new Pair(i,j));
                    vis[i][j]=true;
                    while(!q.isEmpty()){
                        Pair curr=q.poll();
                        int[][] directions={{0,-1},{0,1},{-1,0},{1,0}};
                        int curri=curr.first;
                        int currj=curr.second;
                        for(int k=0;k<4;k++){
                            int newi= curri + directions[k][0];
                            int newj= currj + directions[k][1];
                            if(isSafe(newi,newj,m,n) && grid[newi][newj]=='1' 
                            && !vis[newi][newj]){
                                vis[newi][newj]=true;
                                q.offer(new Pair(newi,newj));
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
/*     private void dfs(char[][] grid,boolean[][] vis,int i,int j,int m,int n){
        vis[i][j]=true;
        int[][] directions={{0,-1},{0,1},{-1,0},{1,0}};
        for(int k=0;k<4;k++){
            int newi= i + directions[k][0];
            int newj= j + directions[k][1];
            if(isSafe(newi,newj,m,n) && grid[newi][newj]=='1' && !vis[newi][newj]){
                dfs(grid,vis,newi,newj,m,n);
            }
        }
    } */
    private boolean isSafe(int i,int j,int m,int n){
        return (i>=0 && i<m && j>=0 && j<n);
    }
}
}
