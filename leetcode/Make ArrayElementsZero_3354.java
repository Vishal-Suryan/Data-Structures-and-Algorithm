class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int validCount = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                if(simulate(nums, i, 1)) validCount++;
                if(simulate(nums, i, -1)) validCount++;
            }
        }
        return validCount;
    }
    private boolean simulate(int[] nums, int start, int dir){
        int n = nums.length;
        int[] arr = nums.clone(); 
        int curr = start;
        while(curr >= 0 && curr < n){
            if(arr[curr] == 0){
                curr += dir;
            }else{
                arr[curr]--; 
                dir = -dir;  
                curr += dir; 
            }
        }
        for(int val : arr){
            if(val != 0) return false;
        }
        return true;
    }
}
