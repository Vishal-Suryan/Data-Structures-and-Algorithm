import java.util.LinkedList;
import java.util.Queue;

public class floodFillBFS {
    class Solution {
    class pair{
        int first;
        int second;
        public pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int origColor=image[sr][sc];
        if(origColor == color) return image;
        int n=image.length;
        int m=image[0].length;
        Queue<pair> q=new LinkedList<>();
        image[sr][sc]=color;
        q.offer(new pair(sr,sc));
        while(!q.isEmpty()){
            pair curr=q.poll();
            int r=curr.first;
            int c=curr.second;
            int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
            for(int i=0;i<4;i++){
                int newr = r+ dir[i][0];
                int newc = c+ dir[i][1];
                if(isSafe(newr,newc,n,m) && image[newr][newc]==origColor){
                    image[newr][newc]=color;
                    q.offer(new pair(newr,newc));
                }
            }
        }
        return image;
    }
    private boolean isSafe(int r,int c,int n,int m){
        return (r>=0 && r<n && c>=0 && c<m);
    }
}
}
