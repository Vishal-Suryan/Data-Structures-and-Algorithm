import java.util.*;
public class chPrime {
    static boolean checkPrime(int num){
        for(int i=2;i<=(int)Math.sqrt(num);i++){
            if(num==1 || num==0){
                return false;
            }else if(num%i==0){
                return false;
            }
        }
        return true;
    }
    
    public static void main (String[] args){
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num=sc.nextInt();
        if(checkPrime(num)==true){
            System.out.println(num+" is  a prime number");
        }else{
            System.out.println(num+" is not a prime number");
        }   
    }
}
