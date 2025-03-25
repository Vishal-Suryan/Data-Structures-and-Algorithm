import java.util.*;
public class team231A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for(int i = 0; i<n; i++){
            int countOne = 0;
            for(int j = 0; j<3; j++){
                int num = sc.nextInt();
                if(num == 1) countOne++;
            }
            if(countOne >= 2) count++;
        }
        System.out.println(count);
        sc.close();
    }
}
