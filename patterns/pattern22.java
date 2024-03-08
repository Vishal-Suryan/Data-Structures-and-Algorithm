public class pattern22 {
    public static void main(String[] args) {
        int N=3;
        for(int i=0;i<2*N-1;i++){
            for(int j=0;j<2*N-1;j++){
                int top=i;
                int left=j;
                int right=(2*N-2)-j;
                int bottom=(2*N-2)-i;
                System.out.print(N-Math.min(Math.min(top,bottom),Math.min(left,right))+" ");
            }
            System.out.println();
        }
    }
}
