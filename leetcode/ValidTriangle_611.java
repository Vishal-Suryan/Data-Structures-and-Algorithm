class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        if(n < 3) return 0;
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < n - 2; i++){
            for(int j = i + 1; j < n - 1; j++){
                int idx = binarySearch(j + 1, n - 1, nums[i] + nums[j], nums);
                if(idx != -1){
                    count += idx - j;
                }
            }
        }
        return count;
    }
    private static int binarySearch(int low, int high, int target, int[] nums){
        int ans = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] < target){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
    public int triangleNumber1(int[] nums) {
        int n = nums.length;
        if(n < 3) return 0;
        Arrays.sort(nums);
        int count = 0;
        for(int k = n - 1; k >= 2; k--){
            int i = 0, j = k - 1;
            while(i < j) {
                if(nums[i] + nums[j] > nums[k]){
                    count += j - i;
                    j--; 
                }else{
                    i++;
                }
            }
        }
        return count;
    }
}