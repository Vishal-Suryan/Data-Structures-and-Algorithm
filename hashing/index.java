import java.util.*;
public class index {
    public static int search(int []nums, int target) {
        // Write your code here.
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],i);
            if(mp.containsKey(target)){
                return mp.get(target);
            }
        }
        return -1;
    }
}