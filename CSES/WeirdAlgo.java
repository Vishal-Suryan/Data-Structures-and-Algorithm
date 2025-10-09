import java.util.*;
class WeirdAlgo{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        while(n != 1){
            System.out.print(n + " ");
            n = (n % 2 != 0) ? n * 3 + 1 : n / 2;
        }
        System.out.print(n);
        sc.close();
    }
}