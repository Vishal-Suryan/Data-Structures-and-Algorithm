import java.util.HashMap;
import java.util.Map;

public class divideArray_2206 {
    class Solution {
    public boolean divideArray(int[] nums) {
        if(nums.length % 2 != 0) return false;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer,Integer> itr : map.entrySet()){
            if(itr.getValue() % 2 != 0){
                return false;
            }
        }
        return true;
    }
}
}
