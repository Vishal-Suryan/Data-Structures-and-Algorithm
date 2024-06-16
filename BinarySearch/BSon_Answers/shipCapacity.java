
public class shipCapacity {
    class Solution {
        public static int minDays(int[] weights,int threshold){
            int countDays=0;
            int sum=0;
            for(int weight : weights){
                sum+=weight;
                if(sum>threshold){
                    countDays++;
                    sum=0;
                    sum+=weight;
                }
            }
            if(sum>0){
                countDays++;
            }
            return countDays;
        }
        public int shipWithinDays(int[] weights, int days) {
            int max=Integer.MIN_VALUE;
            int sum=0;
            for(int weight:weights){
                sum+=weight;
                max=Math.max(max,weight);
            }
            int low=max;
            int ans=-1;
            int high=sum;
            while(low<=high){
                int mid=(low+high)/2;
                int dayCount=minDays(weights,mid);
                if(dayCount<=days){
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
