import java.util.HashMap;
import java.util.Map;
public class goodPair_1521 {
    class Solution {
        public int numIdenticalPairs(int[] nums) {
            int count=0;
            Map<Integer,Integer> mp=new HashMap<>();
            for(int i=0;i<nums.length;i++){
                int val=mp.getOrDefault(nums[i],0);
                if(mp.containsKey(nums[i])){
                    mp.put(nums[i],val+1);
                }else{
                    mp.put(nums[i],1);
                }   
            }
            for(Map.Entry<Integer,Integer> itr: mp.entrySet()){
                int freq=itr.getValue();
                count+=(freq*(freq-1))/2;
            }   
            return count;
        }
    }    
}
