import java.util.Arrays;

public class zeroArrayTransformationII_3356 {
    // Brute Force Approach
    /* class Solution {
        public int minZeroArray(int[] nums, int[][] queries) {
            int n = nums.length;
            int sum = 0;
            for(int num : nums) sum+=num;
            if(sum == 0) return 0;
            int count = 0;
            for(int[] row : queries){
                int idx1 = row[0];
                int idx2 = row[1];
                int val = row[2];
                for(int i = idx1; i<=idx2; i++){
                    if(nums[i] != 0 && nums[i] - val >= 0){
                        nums[i] = nums[i] - val;
                        sum = sum - val;
                    }else if(nums[i] < val){
                        sum = sum - nums[i];
                        nums[i] = 0;
                    }
                }
                count++;
                if(sum == 0) return count; 
            }
            return -1;
        }
    } */
   class Solution {
        public int minZeroArray(int[] nums, int[][] queries) {
            //int n = nums.length;
            
            if (Arrays.stream(nums).allMatch(x -> x == 0)) return 0;
            int left = 1, right = queries.length;
            if (!canMakeZeroArray(right, nums, queries)) return -1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (canMakeZeroArray(mid, nums, queries)) right = mid;
                else left = mid + 1;
            }
            return left;
        }

        private boolean canMakeZeroArray(int k, int[] nums, int[][] queries) {
            int n = nums.length;
            int[] diff = new int[n + 1];
            for (int i = 0; i < k; i++) {
                int left = queries[i][0], right = queries[i][1], val = queries[i][2];
                diff[left] += val;
                diff[right + 1] -= val;
            }
            int currVal = 0;
            for (int i = 0; i < n; i++) {
                currVal += diff[i];
                if (currVal < nums[i]) return false;
            }
            return true;
        }
    }
}
