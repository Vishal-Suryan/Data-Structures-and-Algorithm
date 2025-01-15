public class trappingRainwater {
    class Solution {
        public int trap(int[] height) {
            int[] prefix=prefixMax(height);
            int[] suffix=suffixMax(height);
            int total=0;
            for(int i=0;i<height.length-1;i++){
                int leftMax=prefix[i];
                int rightMax=suffix[i];
                if(height[i]<leftMax && height[i]<rightMax){
                    total+=Math.min(leftMax,rightMax)-height[i];
                }
            }
            return total;
        }
        private int[] prefixMax(int[] nums){
            int[] prefix=new int[nums.length];
            prefix[0]=nums[0];
            for(int i=1;i<nums.length;i++){
                prefix[i]=Math.max(prefix[i-1],nums[i]);
            }
            return prefix;
        }
        private int[] suffixMax(int[] nums){
            int[] suffix=new int[nums.length];
            suffix[nums.length-1]=nums[nums.length-1];
            for(int i=nums.length-2;i>=0;i--){
                suffix[i]=Math.max(suffix[i+1],nums[i]);
            }
            return suffix;
        }
    }
}
