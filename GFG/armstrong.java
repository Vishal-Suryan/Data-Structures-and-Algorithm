
public class armstrong {
    class Solution {
        static String armstrongNumber(int number) {
            // code here
            int n=number;
            int num=0;
            while( n>0){
                int rem=n%10;
                num+=Math.pow(rem,3);
                n/=10;
            }
            return (number==num)?"true":"false";
        }
    }
}
