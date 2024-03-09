import java.util.Scanner;

class Main{
    int countDigit(int num){
        int count=0;
        while(num!=0){
            num=num/10;
            count++;
        }
        return count;
    }
}

public class countDigits {
    public static void main(String[] args) {
        //Approach 1 = Tc =O(n) & SC = O(1)
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num =sc.nextInt();
        Main a=new Main();
        System.out.println("Number of digits in "+num+" is "+a.countDigit(num)); 
        // -----------Approach 2--------------
        //using log base 10 . TC & SC= O(1)
        int digits=(int)Math.log10(num)+1;
        System.out.println("Number of Digits: "+digits);
        //Approach 3 -: convert to string and then print its length
        // TC & SC = O(1)
        String str = Integer.toString(num);
        System.out.println("Number of Digits: "+str.length());
    }
}
