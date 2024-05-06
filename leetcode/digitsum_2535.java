public class digitsum_2535 {
    class Solution {
        public int differenceOfSum(int[] nums) {
            int sum=0;
            int digit_sum=0;
            for(int i=0;i<nums.length;i++){
                sum+=nums[i];
                while(nums[i]>0){            
                    digit_sum+=nums[i]%10;
                    nums[i]/=10;
                }
            }   
            
            return Math.abs(sum-digit_sum);
        }
    }
}
