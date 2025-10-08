class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans = new int[spells.length];
        Arrays.sort(potions);
        int m = potions.length;
        for(int i = 0; i < spells.length; i++){
            int spell = spells[i];
            int low = 0, high = m - 1;
            int idx = m;
            while(low <= high){
                int mid = low + (high - low) / 2;
                long strength = (long) spell * potions[mid];
                if(strength >= success){
                    idx = mid;
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            ans[i] = m - idx;
        }
        return ans;
    }
}