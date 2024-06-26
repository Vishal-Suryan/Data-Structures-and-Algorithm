
public class searcgRotated2 {
    class Solution {
        public boolean search(int[] nums, int target) {
            int low=0,high=nums.length-1;
            while(low<=high){
                int mid=(low+high)/2;
                if(nums[mid]==target){
                    return true;
                }
                if(nums[mid]==nums[low] && nums[high]==nums[mid]){
                    low++;
                    high--;
                    continue;
                }
                if(nums[low]<=nums[mid]){
                    if(nums[low]<=target && nums[mid]>=target){
                        high=mid-1;
                    }else{
                        low=mid+1;
                    }
                }else{
                    if(nums[mid]<=target && nums[high]>=target){
                        low=mid+1;
                    }else{
                        high=mid-1;
                    }
                }
            }
            return false;
        }
    }
}
