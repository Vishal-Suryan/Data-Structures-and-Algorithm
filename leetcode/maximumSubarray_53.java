import java.util.*;
public class maximumSubarray_53 {
    
    public static int maxSubArray(int[] nums) {
        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>maxSum){
                maxSum=sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return maxSum;
    }
    
    public static int SubArray(int[] nums) {
        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        int start=0;
        int ansStart = -1 , ansEnd = -1;
        for(int i=0;i<nums.length;i++){
            if(sum==0){
                start=i;
            }
            sum+=nums[i];
            if(sum>maxSum){
                maxSum=sum;
                ansStart = start;
                ansEnd=i;
            }
            if(sum<0){
                sum=0;
            }
        }
        for(int i=ansStart;i<=ansEnd;i++){
            System.out.print(nums[i] + " ");
        }
        return maxSum;
    }
    public static void main(String[] args){
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(SubArray(nums));
    }

}
