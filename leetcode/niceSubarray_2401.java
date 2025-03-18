public class niceSubarray_2401 {
    class Solution {
        public int longestNiceSubarray(int[] nums) {
            int left = 0;
            int bitMask = 0;
            int maxLength = 0;     
            for (int right = 0; right < nums.length; right++) {
                while ((bitMask & nums[right]) != 0) {
                    bitMask ^= nums[left];
                    left++;
                }
                bitMask |= nums[right];
                maxLength = Math.max(maxLength, right - left + 1);
            }
            return maxLength;
        }
    }
}
