import java.util.Scanner;
public class watermelon4A{ 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int wgt = sc.nextInt();  
        if (wgt > 2 && wgt % 2 == 0) {
            System.out.println("YES");  
        } else {
            System.out.println("NO");
        }
        sc.close(); 
    }
}
