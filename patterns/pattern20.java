/* 
    APPROACH ONE
public class pattern20 {
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            for(int j=0;j<=i;j++){
                System.out.print('*');
            }
            for(int j=0;j<(2*5)-(2*(i+1));j++){
                System.out.print(" ");
            }
            for(int j=0;j<=i;j++){
                System.out.print('*');
            }
            System.out.println();
        }
        for(int i=0;i<5-1;i++){
            for(int j=5-1;j>i;j--){
                System.out.print('*');
            }
            for(int j=0;j<2*(i+1);j++){
                System.out.print(" ");
            }
            for(int j=5-1;j>i;j--){
                System.out.print('*');
            }
            System.out.println(); 
        }
    }
}
 */

 //=====APPROACH TWO======//

public class pattern20{
    public static void main(String[] args) {
        int spaces= 2*5 -2;
        for(int i=1;i<=2*5-1;i++){
            int stars=i;
            if(i>5){
                stars=10-i;
            }
            for(int j=1;j<=stars;j++){
                System.out.print("*");
            }
            for(int j=1;j<=spaces;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=stars;j++){
                System.out.print("*");
            }
            System.out.println();
            if(i>=5){
                spaces+=2;
            }else{
                spaces-=2;
            }
        }
    }
}
