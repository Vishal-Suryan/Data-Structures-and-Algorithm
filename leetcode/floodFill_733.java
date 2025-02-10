public class floodFill_733 {
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            int origColor=image[sr][sc];
            if(origColor == color) return image;
            int n=image.length;
            int m=image[0].length;
            dfs(sr,sc,origColor,color,image,n,m);
            return image;
        }
        private void dfs(int sr, int sc,int origColor,int color,int[][] image,int n,int m){
            image[sr][sc]=color;
            int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
            for(int i=0;i<4;i++){
                int newr = sr+ dir[i][0];
                int newc = sc+ dir[i][1];
                if(isSafe(newr,newc,n,m) && image[newr][newc]==origColor){
                    dfs(newr,newc,origColor,color,image,n,m);
                }
            }
        }
        private boolean isSafe(int r,int c,int n,int m){
            return (r>=0 && r<n && c>=0 && c<m);
        }
    }
}
