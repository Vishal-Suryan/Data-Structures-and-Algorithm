public class smallestDivisor {
    class Solution {
        public static int getThreshold(int[] map, int val){
            int ans = 0;
            for(int i : map) {
                ans += (i + val - 1) / val;
            }
            return ans;
        }
        static int findLargest(int[] nums){
            int max=0;
            for(int num: nums){
                max=Math.max(num,max);
            }
            return max;
        }
        public int smallestDivisor(int[] nums, int threshold) {
            int low=1;
            int high=findLargest(nums);
            int ans=-1;
            while(low<=high){
                int mid =(low+high)/2;
                int value=getThreshold(nums,mid);
                if(value <= threshold){
                    ans =mid;
                    high=mid-1;
                }else{
                    low=mid+1;
                } 
            }
            return ans;
        }
    }
}
