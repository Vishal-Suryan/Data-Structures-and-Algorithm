public class runningSum_1480 {
    class Solution {
        public int[] runningSum(int[] nums) {
            int j=0;
            int[] ans=new int[nums.length];
            int sum=0;
            for(int i=0;i<nums.length;i++){
                sum+=nums[j];
                ans[i]=sum;
                j++;
            }
            return ans;
        }
    }
}
