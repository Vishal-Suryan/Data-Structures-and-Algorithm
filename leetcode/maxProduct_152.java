public class maxProduct_152 {
    class Solution {
        public int maxProduct(int[] nums) {
            double max=Integer.MIN_VALUE;
            double prefix=1;
            double suffix=1;
            for(int i=0;i<nums.length;i++){
                if(prefix==0){
                    prefix=1;
                }
                if(suffix==0){
                    suffix=1;
                }
                prefix*=nums[i];
                suffix*=nums[nums.length-i-1];
                max=Math.max(max,Math.max(suffix,prefix));
            }
            return (int)max;
        }
    }
}
