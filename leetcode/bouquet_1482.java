public class bouquet_1482 {
    class Solution {
        static boolean possible(int[] days,int val,int m,int k){
            int count=0;
            int countBouquet=0;
            for(int day: days){
                if(day<=val){
                    count++;
                }else{
                    countBouquet+=count/k;
                    count=0;
                }
            }
            countBouquet+=count/k;
            if(countBouquet>=m){
                return true;
            }
            return false;
        }
        static int findSmallest(int[] nums){
            int min=nums[0];
            for(int num:nums){
                min=Math.min(min,num);
            }
            return min;
        }
        static int findLargest(int[] nums){
            int max=nums[0];
            for(int num:nums){
                max=Math.max(max,num);
            }
            return max;
        }
        public int minDays(int[] bloomDay, int m, int k) {
            if((m*k)>bloomDay.length){
                return -1;
            }
            int ans=-1;
            int low=findSmallest(bloomDay);
            int high=findLargest(bloomDay);
            while(low<=high){
                int mid=(low+high)/2;
                boolean check = possible(bloomDay,mid,m,k);
                if(check==true){
                    ans=mid;
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            return ans;
        }
    }
}
