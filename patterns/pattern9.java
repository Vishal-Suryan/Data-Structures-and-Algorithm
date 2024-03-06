class pattern {
    void pyramid(){
        for(int i=0;i<5;i++){
            for(int k=0;k<4-i;k++){
                System.out.print(" ");
            }
            for(int j=0;j<2*i+1;j++){
                System.out.print("*");
            }
            for(int k=0;k<4-i;k++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    void reversefullpyramid(){
        for(int i=0;i<5;i++){
            for(int j=0;j<i;j++){
                System.out.print(" ");
            }
            for(int j=0;j<9-2*i;j++){
                System.out.print("*");
            }
            for(int j=0;j<i;j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
public class pattern9{
    public static void main(String[] args) {
        pattern p = new pattern();
        p.pyramid();
        p.reversefullpyramid();
    }
}