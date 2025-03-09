public class alternatingGroups2_3208 {
    /// This Solution doesn't works for very large inputs
    /* class Solution {
        public int numberOfAlternatingGroups(int[] colors, int k) {
            int n = colors.length;
            int count = 0;  
            for (int i = 0; i < n; i++) {
                if (isAlternating(i, k, colors, n)) {
                    count++;
                }
            }
            return count;
        }
    
        private boolean isAlternating(int start, int k, int[] colors, int n) {
            for (int i = 0; i < k - 1; i++) {
                int current = (start + i) % n;
                int next = (start + i + 1) % n;
                if (colors[current] == colors[next]) {
                    return false;
                }
            }
            return true;
        }
    } */
    class Solution {
        public int numberOfAlternatingGroups(int[] colors, int k) {
            int res = 0;
            int left = 0;
            int n = colors.length;
            for(int right = 1; right < (n + k - 1); right++){
                if(colors[right % n] == colors[(right - 1) % n]){
                    left = right;
                }
                if(right - left + 1 == k){
                    res++;
                    left++;
                }
            }
            return res;
        }
    }
}
