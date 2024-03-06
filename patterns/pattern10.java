import java.util.*;
class pattern{
    static void halfdiamond(int n){
        for(int i=0;i<=2*n-1;i++){
            int stars=i;
            if(i>n){
                stars=2*n-i;
            }
            for(int j=0;j<=stars;j++){
                System.out.print("*");
            }
        System.out.println();
        }
    }
}
class pattern10 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter the number of rows:");
        int n=sc.nextInt();
        pattern p=new pattern();
        p.halfdiamond(n);
    }
}
