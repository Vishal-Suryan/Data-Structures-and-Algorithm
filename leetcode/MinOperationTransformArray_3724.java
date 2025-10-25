class Solution {
    public long minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        long count = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            count += Math.abs(nums1[i] - nums2[i]);
            int dist = Math.min(Math.abs(nums2[n] - nums2[i]), Math.abs(nums2[n] - nums1[i]));
            if(Math.min(nums1[i], nums2[i]) <= nums2[n] && nums2[n] <= Math.max(nums1[i], nums2[i])){
                dist = 0;
            }
            min = Math.min(min, dist);   
        }
        return count + min + 1;
    }
}