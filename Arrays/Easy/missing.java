import java.util.*;
public class missing {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int ld=sc.nextInt();
        System.out.print("Enter the Size of Array: ");
        int size=sc.nextInt();
        int [] arr = new int[size];
        System.out.print("Enter Elements: ");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        missingNumber(ld, arr);
        
    }

    static void missingNumber(int ld,int[] arr){ //works just fine but takes more time to run O(N)
        int i=0;
        Arrays.sort(arr);
        while(i<arr.length){
            if(arr[arr.length-1]!=ld){
                System.out.println("Number Missing in Array: "+ld);
                break;
            }
            else if(arr[i]!=i){
                System.out.println("Number Missing in Array: "+i);
                break;
            }
            i++;
        }
        return;
    }
    /* class Solution {                 OPTIMAL APPROACH ->> TAKES LESS TIME IN LINEAR 
        public int missingNumber(int[] arr) {
            int last_digit=arr.length;
            int sum1= (last_digit*(last_digit+1))/2;
            int sum2 = 0;   
            for(int i=0;i<arr.length;i++){
                sum2+=arr[i];
            }
            return sum1 - sum2 ;
        }
    } */
}
