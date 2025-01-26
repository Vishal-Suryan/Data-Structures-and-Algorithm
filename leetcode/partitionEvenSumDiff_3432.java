public class partitionEvenSumDiff_3432 {
    class Solution {
        public int countPartitions(int[] nums) {
            int sum=0;
            for(int num : nums){
                sum+=num;
            }
            int res=0;
            int runningSum=0;
            for(int i=0;i<nums.length-1;i++){
                runningSum+= nums[i];
                int diff =runningSum - (sum - runningSum);
                if(diff % 2==0){
                    res+=1;
                }
            }
            return res;
        }
    }
}
