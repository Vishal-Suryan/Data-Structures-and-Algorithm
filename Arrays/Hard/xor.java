import java.util.*;

public class xor {
    public class Solution {
        public int solve(int[] A, int B) {
            int count=0;
            Map<Integer,Integer>mp=new HashMap<>();
            int xor=0;
            mp.put(0,1);
            for(int i=0;i<A.length;i++){
                xor=xor^A[i];
                /* if(xor==B){
                    count++;
                } */
                if(mp.containsKey(xor^B)){
                    count+=mp.get(xor^B);
                }
                if(mp.containsKey(xor)){
                    mp.put(xor,mp.get(xor)+1);
                }else{
                    mp.put(xor,1);
                }
            }
            return count;    
        }
    }
    
}
