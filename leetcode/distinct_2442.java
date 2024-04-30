import java.util.*;
class Solution {
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            int rev = 0;
            set.add(num);
            while (num > 0) {
                int rem = num % 10;
                rev = rev * 10 + rem;
                num /= 10;
            }
            set.add(rev);
        }
        return set.size();
    }
}