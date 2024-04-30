import java.util.*;
class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int len=piles.length;
        int sum=0;
        int j=len/3;
        for(int i=len-2;i>len/3-1;i-=2){
            if(i>=j){
                sum+=piles[i];
            }
        }
        return sum;
    }
}