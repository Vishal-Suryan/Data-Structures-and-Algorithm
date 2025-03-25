import java.util.*;
public class bit282A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int value = 0;
        int n = sc.nextInt();
        for(int i = 0; i<n; i++){
            String str = sc.next();
            if(str.equals("++X") || str.equals("X++")){
                value++;
            }else{
                value--;
            }
        }
        System.out.println(value);
        sc.close();
    }
}
