import java.util.*;
public class longestSum {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter size: ");
        int size=sc.nextInt();
        int [] arr = new int[size];
        System.out.print("Enter Elements: ");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("Enter sum: ");
        int sum=sc.nextInt();
        
        longestSubarraySum(sum, arr);
        
    }

    static void longestSubarraySum(int targetSum,int[] arr){
        int count=0;
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                if(sum==targetSum){
                    count=Math.max(count,j-i+1);
                }
            }
        }
        System.out.println("Longest SubArray Sum Len ="+count);
        return;
    }
}
