public class countdigit4 {
    class Solution {
        public static int countNumberswith4(int n) {
            // code here
            int count = 0;
            for (int i = 1; i <= n; i++) {
              // Check if '4' is present in the string representation of the number
              if (Integer.toString(i).contains("4")) {
                count++;
              }
            }
            return count;
        }
    }
    
}
