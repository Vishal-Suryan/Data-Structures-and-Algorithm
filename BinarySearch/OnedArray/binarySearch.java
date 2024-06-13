public class binarySearch {
    // Iterative + recursive code 
    class Solution {
        static int find(int[] nums,int low,int high,int target){
            if(low>high){
                return -1;
            }
            int mid=(low+high)/2;
            if(nums[mid]==target){
                return mid;
            }else if(target>nums[mid]){
                return find(nums,mid+1,high,target);
            }
            return find(nums,low,mid-1,target);
        }
        public int search(int[] nums, int target) {
            return find(nums,0,nums.length-1,target);
        }
        public int search1(int[] nums, int target) {
            int low=0;
            int high=nums.length-1;
            while(low<=high){
                int mid=(low+high)/2;
                if(target==nums[mid]){
                    return mid;
                }else if(target>nums[mid]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
            return -1;
        }
    }
    
}
