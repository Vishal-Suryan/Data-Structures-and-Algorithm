public class trappingRainwater_11 {
    class Solution {
        public int maxArea(int[] height) {
            int i=0;
            int j=height.length-1;
            int ans=Integer.MIN_VALUE;
            while(i<j){
                int min=Math.min(height[i],height[j]);
                ans=Math.max(min*(j-i),ans);
                if(height[i]<height[j]){
                    i++;
                }else{
                    j--;
                }
            }
            return ans;
        }
    }
}
