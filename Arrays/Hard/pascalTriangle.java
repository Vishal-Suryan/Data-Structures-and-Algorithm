public class pascalTriangle {
    public static int NCR(int n,int r){
        /*
         to Compute any element in a pascal triangle we have to use formula -:
                nCr(n-1,r-1)
         */
        int res=1;
        for(int i=0;i<r;i++){
            res=res*(n-i);
            res=res/(i+1);
        }
        return res;
    }
    public static void printPascalRow(int row){
        int ans=1;
        System.out.print(ans+" ");
        for(int i=1;i<row;i++){
            ans=ans*(row-i);
            ans=ans/i;
            System.out.print(ans+" ");
        }
        return;
    }
    public static void generatePascalTriangle(int n){
        for(int i=1;i<=n;i++){
            printPascalRow(i);
            System.out.println();
        }
        return;
    }
    public static void main(String[] args){
        //System.out.println(NCR(4 - 1,2 - 1));
        printPascalRow(5);
        System.out.println();
        generatePascalTriangle(5);
    }
}
