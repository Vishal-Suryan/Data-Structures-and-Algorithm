public class firstLast_34 {
    class Solution {
        public static int lowerBound(int []arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ans = mid;

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
        public static int upperBound(int[] arr, int x, int n) {
        int low = 0, high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int lb=(lowerBound(nums,n,target));
        if(lb==n || nums[lb]!=target) return new int[] {-1,-1};
        return new int[] {lb,upperBound(nums,target,n)-1};
    }
}
}
