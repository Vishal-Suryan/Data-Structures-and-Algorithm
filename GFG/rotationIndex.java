
public class rotationIndex {
    class Solution {
        int findKRotation(int nums[], int n) {
            // code here
                int low=0;
                int high=nums.length-1;
                int ans=Integer.MAX_VALUE;
                int index=-1;
                while(low<=high){
                    int mid=(low+high)/2;
                    if(nums[low]<=nums[high]){
                        if(ans>nums[low]){
                            ans=nums[low];
                            index=low;
                        }
                        break;
                    }
                    if(nums[low]<=nums[mid]){
                        if(ans>nums[low]){
                            ans=nums[low];
                            index=low;
                        }
                        low=mid+1;
                    }else{
                        if(ans>nums[mid]){
                            ans=nums[mid];
                            index=mid;
                        }
                        high=mid-1;
                    }
                }
                return index;
        }
    }
}
