import java.util.HashMap;
import java.util.Map;

public class countSubarray_560 {
    class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int sum = 0;
        int ctr = 0;
        hashMap.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            sum+= nums[i];
            int check = sum - k;
            if(hashMap.containsKey(check)) {
                ctr += hashMap.get(check);
            }
            if(!hashMap.containsKey(sum))
                hashMap.put(sum, 1);
            else{
                hashMap.replace(sum, hashMap.get(sum)+1);
            }
        }
        return ctr;
    }
}
}
