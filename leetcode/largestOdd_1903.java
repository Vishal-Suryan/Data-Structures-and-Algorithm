public class largestOdd_1903 {
    class Solution {
        public String largestOddNumber(String num) {
            for (int i = num.length() - 1; i >= 0; i--) {
                char chr = num.charAt(i);
                if ((chr - '0') % 2 != 0) {
                    return num.substring(0, i + 1);
                }
            }
            return "";
        }
    }
    
}
