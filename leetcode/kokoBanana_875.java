public class kokoBanana_875 {
    class Solution {
        static double eatRate(int [] nums,int rate){
            double totHours=0;
            for(int num: nums){
                double hours = Math.ceil((double) num / rate);
                totHours +=  hours;
            }
            return totHours;
        }
        static int findLargest(int[] nums){
            int max=nums[0];
            for(int num: nums){
                max=Math.max(max,num);
            }
            return max;
        }
        public int minEatingSpeed(int[] piles, int h) {
            int low=1;
            int high=findLargest(piles);
            int ans=-1;
            while(low<=high){
                int mid=low +(high - low)/2;
                double reqTime=eatRate(piles,mid);
                if(reqTime<=h){
                    ans= mid;
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            return ans;
        }
    }
}
