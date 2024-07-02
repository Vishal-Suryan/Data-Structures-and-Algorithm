import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class intersectionTwoArrays_350 {
    class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            mp.put(nums1[i],mp.getOrDefault(nums1[i],0)+1);
        }
        ArrayList<Integer> temp=new ArrayList<>();
        for(int num: nums2){
            if(mp.containsKey(num)){
                int count=mp.get(num);
                temp.add(num);
                count--;
                mp.put(num,count);
                if(count==0){
                    mp.remove(num);
                }
            }
        }
        int[] ans=new int[temp.size()];
        for(int i=0;i<temp.size();i++){
            ans[i]=temp.get(i);
        }
        return ans;
    }
}
}
