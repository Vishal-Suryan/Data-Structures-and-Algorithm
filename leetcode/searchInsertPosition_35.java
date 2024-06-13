public class searchInsertPosition_35 {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int low=0,high=nums.length-1;
            int index=-1;
            while(low<=high){
                int mid=(low+high)/2;
                if(nums[mid]==target){
                    return mid;
                }else if(nums[mid]>target){
                    high=mid-1;
                    index=mid;
                }else{
                    low=mid+1;
                }
            }
            if(target>nums[nums.length-1]){
                return nums.length;
            }
            return index;
        }
    }
}
