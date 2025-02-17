import java.util.LinkedList;
import java.util.Queue;

public class rottingOranges {
    class Solution {
    class Pair{
        int first;
        int second;
        int time;
        public Pair(int first, int second, int time){
            this.first=first;
            this.second=second;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        int[][] vis=new int[n][m];
        int countFresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j,0));
                    vis[i][j]=2;
                }else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1) countFresh++;
            }
        }
        int time=0;
        int count=0;
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int r=q.peek().first;
            int c=q.peek().second;
            int t=q.peek().time;
            time=Math.max(t,time);
            q.poll();
            for(int k=0;k<4;k++){
                int newr= r + dir[k][0];
                int newc= c + dir[k][1];
                if(isSafe(newr,newc,n,m) && vis[newr][newc]==0 && grid[newr][newc]==1){
                    q.offer(new Pair(newr,newc,t+1));
                    vis[newr][newc]=2;
                    count++;
                }
            }
        }
        if(count != countFresh) return -1;
        return time;
    }
    private boolean isSafe(int r,int c,int n,int m){
        return (r>=0 && r<n && c>=0 && c<m);
    }
}
}
