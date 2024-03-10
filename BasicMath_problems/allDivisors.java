import java.util.*;

public class allDivisors {
    static int getDivisors(int num){
        /* 
         Optimal Approach -
         Idea is to iterate till sqrt of the number
         and also print the quotient  if it's a divisor 
         corner case - when it's a perfect number 
         TC = O(sqrt(n)) && SC =O(1) 
         */
        int dummy=num;
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=1;i<=(int)Math.sqrt(dummy);i++){
            if(dummy%i==0){
                arr.add(i);
            }
            if(i != dummy/i){//checking if i  & dummy/i are not same, because in that case i will be added twice
                arr.add(dummy/i);
            }
        }
        Iterator<Integer> itr = arr.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next()+" ");
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num= sc.nextInt();
        System.out.print("The divisors of "+num+ " are :");
        getDivisors(num);
    }
}
