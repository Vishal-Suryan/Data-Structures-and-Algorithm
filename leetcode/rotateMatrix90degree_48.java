public class rotateMatrix90degree_48 {
    class Solution {
        public static void rotate(int[][] matrix) {
            int m=matrix.length;
            for(int i=0;i<m;i++){
                for(int j=i;j<m;j++){
                    int temp= matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=temp;
                }
            }   
            for(int x=0;x<matrix.length;x++){
                int left=0;
                int right=matrix.length-1;
                while(left<right){
                    int temp=matrix[x][right];
                    matrix[x][right]=matrix[x][left];
                    matrix[x][left]=temp;
                    left++;
                    right--;
                    
                }
            }
            return;
        }
    }
}
