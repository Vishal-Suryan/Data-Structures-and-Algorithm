public class permutation {
    class Solution {
        public void nextPermutation(int[] nums) {
            int idx=-1;
            for(int i= nums.length-2;i>=0;i--){
                if(nums[i]<nums[i+1]){
                    idx=i;
                    break;
                }
            }
            if(idx==-1){
                for(int i=0;i<nums.length/2;i++){
                    int temp=nums[i];
                    nums[i]=nums[nums.length-i-1];
                    nums[nums.length-i-1]=temp;
                }
                return ;
            }else{
                for(int i=nums.length-1;i>idx;i--){
                    if(nums[i]>nums[idx]){
                        int temp= nums[i];
                        nums[i]=nums[idx];
                        nums[idx]=temp;
                        break;
                    }
                }
                int i=idx+1;
                int j=nums.length-1;
                while(i<j){
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                    i++;
                    j--;
                }
                return ;
            }
        }
    }
}
