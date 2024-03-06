public class reversepyramid {
    public static void main(String[] args) {
        for(int i=0;i<=5;i++){
            int j=1;
            for(int k=5;k>i;k--){
                System.out.print(j);
                j++;
            }
            System.out.println();
        }
    }
    
}
