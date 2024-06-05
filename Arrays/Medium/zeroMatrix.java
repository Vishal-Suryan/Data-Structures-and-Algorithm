public class zeroMatrix {
    public static void markRow(int n,int[][]matrix,int row){
        for(int i=0;i<n;i++){
            matrix[row][i]=-1;
        }
        return;
    }
    public static void markCol(int m,int[][]matrix,int col){
        for(int i=0;i<m;i++){
            matrix[i][col]=-1;
        }
        return;
    }
    public static void setZeros1(int [][] matrix){ //Brute Force Solution TC = O(N^3)
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    markRow(n,matrix,i);
                    markCol(m,matrix,j);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==-1){
                    matrix[i][j]=0;
                }
            }
        }
        return;
    }
    public static void setZeros2(int [][] matrix){ // Better Solution TC=2*O(N^2) SC=O(n+m)
        int n=matrix.length;
        int m=matrix[0].length;
        int [] hashRow=new int[n];
        int [] hashCol=new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    hashCol[j]++;
                    hashRow[i]++;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(hashCol[j]!=0 || hashRow[i]!=0){
                    matrix[i][j]=0;
                }
            }
        }
        return;
    }
    public static void main(String[] args){
        int [][] matrix={{1,1,1},{1,0,1},{1,1,1}};
        setZeros2(matrix); 
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
