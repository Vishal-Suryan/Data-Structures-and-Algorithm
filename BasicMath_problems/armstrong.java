import java.util.Scanner;
public class armstrong {
    static boolean checkArmstrong(int num){
        int dummy = num;
        int sum=0;

        while(dummy!=0){
            int remainder=dummy%10;
            sum+= Math.pow(remainder, 3);
            dummy/=10;
        }
        if(sum==num){
            return true;
        }else{
        return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num =  sc.nextInt();
        if(checkArmstrong(num)==true){
            System.out.println(num + " is an Armstrong Number");
        } else {
            System.out.println(num + " is not an Armstrong Number");
        }
    }
}
