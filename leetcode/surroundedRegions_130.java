public class surroundedRegions_130 {
    class Solution {
        public void solve(char[][] board) {
            int m=board.length;
            int n=board[0].length;
            for(int i = 0; i<n; i++){
                if(board[0][i] == 'O') floodFill(0,i,m,n,board);
                if(board[m-1][i] == 'O') floodFill(m-1,i,m,n,board);
            }
            for(int i = 0; i<m; i++){
                if(board[i][0] == 'O') floodFill(i,0,m,n,board);
                if(board[i][n-1] == 'O') floodFill(i,n-1,m,n,board);
            }
            for(int i = 0; i<m; i++){
                for(int j = 0; j<n; j++){
                    if(board[i][j] == 'O') board[i][j] = 'X';
                    if(board[i][j] == 'V') board[i][j] = 'O';
                }
            }
            return;
        }
        private void floodFill(int r, int c, int m, int n, char[][] board){
            board[r][c] = 'V';
            int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
            for(int i = 0; i<4; i++){
                int newr= r + dir[i][0];
                int newc= c + dir[i][1];
                if(isSafe(newr, newc, m, n) && board[newr][newc] == 'O'){
                    floodFill(newr, newc, m, n, board);
                }
            }
        }
        private boolean isSafe(int r, int c, int m, int n){
            return (r >= 0 && r < m && c >=0 && c < n);
        }
    }
}
