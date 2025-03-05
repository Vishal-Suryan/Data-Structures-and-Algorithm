public class colouredCells_2579 {
    class Solution {
        public long coloredCells(int n) {
            if(n == 0) return 0;
            long ans = 1;
            int increment = 4;
            while(n != 1){
                ans += increment;
                increment += 4;
                n--;
            }
            return ans;
        }
    }
}
