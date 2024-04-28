import java.util.*;
class maxFreqCount_3005{
    class Solution {
        public int maxFrequencyElements(int[] nums) {
            Map<Integer,Integer> mp=new HashMap<>();
            for(int i=0;i<nums.length;i++){
                int count=mp.getOrDefault(nums[i],0);
                if(mp.containsKey(nums[i])){
                    mp.put(nums[i],count+1);
                }else{
                    mp.put(nums[i],1);
                }
            }
            int count=0;
            int maxFreq=1;
            for(Map.Entry<Integer,Integer> itr: mp.entrySet()){
                int freq=itr.getValue();
                if(maxFreq<freq){
                    maxFreq=freq;
                    count=1;
                }else if(maxFreq==freq){
                    count++;
                }
            }
            return count*maxFreq;
        }
    }    
}
