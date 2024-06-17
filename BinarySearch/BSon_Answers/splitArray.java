
public class splitArray {
    class Solution {
        public static int countSubarray(int[] nums,int val){
            int count=1;
            int sum=0;
            for(int num: nums){
                if(sum+num<=val){
                    sum+=num;
                }else{
                    count++;
                    sum=num;
                }
            }
            return count;
        }
        public int splitArray(int[] nums, int k) {
            if(nums.length<k){
                return -1;
            }
            int max=Integer.MIN_VALUE ; 
            int sum=0;
            for(int num:nums){
                max=Math.max(max,num);
                sum+=num;
            }
            int low=max , high=sum;
            while(low<=high){
                int mid=(low+high)/2;
                int count=countSubarray(nums,mid);
                if(count>k){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
            return low;
        }
    }
}
