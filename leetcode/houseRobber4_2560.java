import java.util.Arrays;

public class houseRobber4_2560 {
    class Solution {
        public int minCapability(int[] nums, int k) {
            int left = Arrays.stream(nums).min().getAsInt();
            int right = Arrays.stream(nums).max().getAsInt();
            while(left < right){
                int mid = left + (right - left) / 2;
                if(canRobAtleastK(nums, mid, k)){
                    right = mid;
                }else{
                    left = mid + 1;
                }
            }
            return left;
        }
        private boolean canRobAtleastK(int[] nums, int capability, int k){
            int count = 0;
            int i = 0;
            while(i < nums.length){
                if(nums[i] <= capability){
                    count++;
                    i += 2;
                }else{
                    i++;
                }
                if(count >= k){
                    return true;
                }
            }
            return false;
        }
    }
}
