class Solution {
    public int nextBeautifulNumber(int n) {
        for(int i = n + 1; i < 1_000_000_000; i++){
            if(isBalanced(i)) return i;
        }
        return -1;
    }
    private boolean isBalanced(int n){
        int[] freq = new int[10];
        while(n != 0){
            int d = n % 10;
            freq[d]++;
            n /= 10;
        }
        for(int i = 0; i < 10; i++){
            if(freq[i] != 0 && freq[i] != i) return false;
        }
        return true;
    }
}