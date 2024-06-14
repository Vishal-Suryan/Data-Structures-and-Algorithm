public class minIncrement_945 {
    class Solution {
        public static int findMax(int[] nums){
            int max=Integer.MIN_VALUE;
            for(int i=0;i<nums.length;i++){
                max=Math.max(nums[i],max);
            }
            return max;
        }
        public int minIncrementForUnique(int[] nums) {
            int max=findMax(nums);
            int n=nums.length;
            int[] freq=new int[n+max];
            for(int num : nums){
                freq[num]++;
            }
            int moves=0;
            for(int i=0;i<freq.length;i++){
                if(freq[i]<=1){
                    continue;
                }
                int extra=freq[i]-1;
                moves+=extra;
                freq[i+1]+=extra;
                freq[i]=1;
            }
            return moves;
        }
    }
}
