import java.util.LinkedList;
import java.util.Queue;

public class matrix0_1 {
    class Solution {
    class Node{
        int first;
        int second;
        int third;
        public Node(int first, int second, int third){
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n= mat[0].length;
        int[][] vis = new int[m][n];
        int[][] dist = new int[m][n];
        Queue<Node> q = new LinkedList<>();
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(mat[i][j]==0){
                    q.offer(new Node(i,j,0));
                    vis[i][j]=1;
                }else{
                    vis[i][j]=0;
                }
            }
        }
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int d = q.peek().third;
            dist[row][col]=d;
            q.poll();
            for(int i = 0; i<4; i++){
                int newr = row + dir[i][0];
                int newc = col + dir[i][1];
                if(isSafe(newr, newc, m, n) && vis[newr][newc] == 0){
                    vis[newr][newc]=1;
                    q.offer(new Node(newr, newc, d + 1));
                }
            }
        }
        return dist;
    }
    private boolean isSafe(int r, int c, int m, int n){
        return (r>=0 && r<m && c>=0 && c<n);
    }
}
}
