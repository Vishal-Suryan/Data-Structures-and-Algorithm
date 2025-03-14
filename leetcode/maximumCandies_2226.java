public class maximumCandies_2226 {
    class Solution {
        public int maximumCandies(int[] candies, long k) {
            long sum = 0;
            for(int candy : candies){
                sum += candy;
            }
            if(sum < k) return 0;
            int left = 1;
            int right = Arrays.stream(candies).max().getAsInt();
            int result = 0;
            while(left<=right){
                int mid = left + (right - left) / 2;
                if(canDistribute(candies, k, mid)){
                    result = mid;
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            return result;
        }
        private boolean canDistribute(int[] candies, long k, int candiesPerChild){
            long count = 0;
            for(int candy : candies){
                count += candy / candiesPerChild;
            }
            return (count >= k);
        }
    }
}
