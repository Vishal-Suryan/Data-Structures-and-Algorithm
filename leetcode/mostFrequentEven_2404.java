import java.util.*;
class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        int mostFrequentEven = -1;
        for (int num : nums) {
            if (num % 2 == 0) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
                if (freqMap.get(num) > maxFreq) {
                    maxFreq = freqMap.get(num);
                    mostFrequentEven = num;
                } else if (freqMap.get(num) == maxFreq && num < mostFrequentEven){
                    mostFrequentEven = num;
                }
            }
        }
        return mostFrequentEven;
    
    }
}