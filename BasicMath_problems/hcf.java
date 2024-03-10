public class hcf {
    //Approach 2 ---OPtimal ---Euclidean theorem
    // TC = O(logN) , SC = O(1)
    static int gcd(int a, int b) {
        if  (b == 0){
        return a;
        }
        return gcd(b, a % b);
        
    }
    public static void main(String[] args) {
        //Approach 1 -- TC =O(N) && SC =O(1) 
        //Brute Force  Approach to find the HCF of two numbers
        int num= 13;
        int num2=69;
        int min=Math.min(num, num2);
        int gcd=1;
        for(int i=1;i<=min;i++){
            if(num%i==0 && num2%i==0){
                gcd=i;
            }
        }
        System.out.println("Greatest Common Divisor of "+num+" and "+num2 + " is: "+gcd);
        System.out.println(gcd(40,20));
    }
}
