public class checkpalindrome {
    static int reverse(int num) {
        int rev=0;
        while(num!=0){
            int remainder = num % 10;
            rev = rev*10+remainder;
            num=num/10;
        }
        return rev;
    }
    public static void main(String[] args) {
        int num =1331;
        if(num== reverse(num)){
            System.out.println("Number is Palindrome");
        }else{
            System.out.println( "Number is not a palindrome");
        }
    }
}
