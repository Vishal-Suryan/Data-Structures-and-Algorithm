class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int low = 1;
        int high = nums.size() / 2;
        int ans = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(helper(nums, mid)){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            } 
        } 
        return ans;
    }
    public boolean helper(List<Integer> nums, int k) {
        int n = nums.size();
        int[] inc = new int[n];
        inc[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                inc[i] = inc[i - 1] + 1;
            } else {
                inc[i] = 1;
            }
        }
        for (int i = 2 * k - 1; i < n; i++) {
            if (inc[i] >= k && inc[i - k] >= k) return true;
        }
        return false;
    }
}