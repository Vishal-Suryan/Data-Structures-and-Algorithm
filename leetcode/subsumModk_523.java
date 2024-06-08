import java.util.LinkedHashMap;
import java.util.Map;

public class subsumModk_523 {
    class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer>mp=new LinkedHashMap<>();
        int sum=0;
        mp.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(mp.containsKey(sum%k)){
                int valIdx=mp.get(sum%k);
                if(i-valIdx>=2){
                    return true;
                }
            }else{
                mp.put(sum%k,i);
            }
        }
        return false;
    }
}
}
