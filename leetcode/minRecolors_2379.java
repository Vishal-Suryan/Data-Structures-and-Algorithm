public class minRecolors_2379 {
    class Solution {
        public int minimumRecolors(String blocks, int k) {
            int min = Integer.MAX_VALUE;
            for(int i = 0; i<blocks.length(); i++){
                int start = i;
                int end = i + k - 1;
                if(end >= blocks.length()) break;
                min = Math.min(min, getRecolor(start, end, blocks));
            }
            return min;
        }
        private int getRecolor(int start, int end, String blocks){
            int count = 0;
            for(int i = start; i<=end; i++){
                if(blocks.charAt(i) == 'W') count++;
            }
            return count;
        }
    }
}
