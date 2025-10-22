// class Solution {
//     public int maxFrequency(int[] nums, int k, int numOperations) {
//         int min = Integer.MAX_VALUE;
//         int max = Integer.MIN_VALUE;
//         int ans = 0;
//         for(int num : nums){
//             max = Math.max(max, num);
//             min = Math.min(min, num);
//         }
//         int[] freq = new int[max + 1];
//         for(int num : nums){
//             freq[num]++;
//         }
//         for(int i = 1; i <= max; i++){
//             freq[i] += freq[i - 1];
//         }
//         for(int curr = min; curr <= max; curr++){
//             int l = Math.max(min, curr - k);
//             int r = Math.min(max, curr + k);
//             int f = freq[curr] - freq[curr - 1];
//             int extra = Math.min(numOperations, freq[r] - freq[l - 1] - f);
//             ans = Math.max(ans, f + extra);
//         }
//         return ans;
//     }
// }
class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int max = Integer.MIN_VALUE;
        int ans = 0;
        for(int num : nums){
            max = Math.max(max, num);
        }
        int[] freq = new int[max + 1];
        for(int num : nums){
            freq[num]++;
        }
        for(int i = 1; i <= max; i++){
            freq[i] += freq[i - 1];
        }
        for(int curr = 0; curr <= max; curr++){
            if(freq[curr] == 0) continue;
            int l = Math.max(0, curr - k);
            int r = Math.min(max, curr + k);
            int totalCount = freq[r] - ((l > 0) ? freq[l - 1] : 0);
            int currCount = freq[curr] - ((curr > 0) ? freq[curr - 1] : 0);
            int needConversion = totalCount - currCount; 
            int maxPossibleFreq = Math.min(numOperations, needConversion) + currCount;
            ans = Math.max(ans, maxPossibleFreq);
        }
        return ans;
    }
}