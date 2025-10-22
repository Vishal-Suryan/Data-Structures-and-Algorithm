class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(max, num);
        }
        max += k;
        Map<Integer, Integer> dat = new TreeMap<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            int l = Math.max(num - k, 0);
            int r = Math.min(num + k, max);
            dat.put(l, dat.getOrDefault(l, 0) + 1);
            dat.put(r + 1, dat.getOrDefault(r + 1, 0) - 1);
            dat.putIfAbsent(num, dat.getOrDefault(num, 0));
        }
        int ans = 1;
        int cumSum = 0;
        for(int target : dat.keySet()){
            int val = dat.get(target);
            cumSum += val;
            int targetFreq = freq.getOrDefault(target, 0);
            int needConversion = cumSum - targetFreq;
            int maxPossibleFreq = Math.min(needConversion, numOperations);
            ans = Math.max(ans, maxPossibleFreq + targetFreq);
        }
        return ans;
    }
}