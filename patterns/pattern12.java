/* import java.util.*;
class Triangle{
    void rightSide_triangle(int n){
        for(int i=0;i<n;i++){
            int start=1;
            for(int j=0;j<=i;j++){
                System.out.print(start);
                start+=1;
            }
            int spaces=n-i-1;
            while(spaces!=0){
                System.out.print("*");
                spaces-=1;
            }
        System.out.println();
        }
    }
    void leftSide_triangle(int n){
        for(int i=0;i<n;i++){
            int spaces=n-i-1;
            while(spaces!=0){
                System.out.print("*");
                spaces-=1;
            }
            int start=1;
            for(int j=0;j<=i;j++){
                System.out.print(start);
                start+=1;
            }
        System.out.println();
        }
    }

}
public class pattern12 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter the number of rows:");
        int n=sc.nextInt();
        Triangle t = new Triangle();
        t.rightSide_triangle(n);
        t.leftSide_triangle(n);
    }
}
 */
public class pattern12 {
    public static void main(String[] args) {
        for(int i=1;i<=5;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            for(int j=0;j<2*(5-i);j++) {
            	System.out.print("*");
        	}
            for(int j=i;j>0;j--) {
                System.out.print(j);
            }
        System.out.println();
        }
    }
}