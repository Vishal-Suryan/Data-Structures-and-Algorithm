import java.util.HashMap;
import java.util.Map;

public class handofStraight_846 {
    class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize !=0){
            return false;
        }
        Map <Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<hand.length;i++){
            mp.put(hand[i],mp.getOrDefault(hand[i],0)+1);
        }
        for(int itrCard :hand){
            if(!mp.containsKey(itrCard)){
                continue;
            }
            int currcard=itrCard;
            while(mp.containsKey(currcard-1)){
                currcard--;
            }
            for(int i=0;i<groupSize;i++){
                int card= currcard+i;
                if(!mp.containsKey(card)){
                    return false;
                }
                mp.put(card,mp.get(card)-1);
                if(mp.get(card)==0){
                    mp.remove(card);
                }
            }
        }
        return true;
    }
}
}
