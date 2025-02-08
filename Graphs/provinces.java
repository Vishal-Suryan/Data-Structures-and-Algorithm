import java.util.LinkedList;
import java.util.Queue;

public class provinces {
    class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] vis=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                count++;
                //dfs(isConnected,vis,i,n);
                //bfs
                Queue<Integer> q=new LinkedList<>();
                q.offer(i);
                vis[i]=true;
                while(!q.isEmpty()){
                    int curr=q.poll();
                    for(int j=0;j<n;j++){
                        if(isConnected[curr][j]==1 && !vis[j]){
                            vis[j]=true;
                            q.offer(j);
                        }
                    }
                }
            }
        }
        return count;
    }
/*     private void dfs(int[][] isConnected,boolean[] vis,int curr,int n){
        for(int i=0;i<n;i++){
            if(isConnected[curr][i]==1 && !vis[i]){
                vis[i]=true;
                dfs(isConnected,vis,i,n);
            }
        }
    } */
}
}
