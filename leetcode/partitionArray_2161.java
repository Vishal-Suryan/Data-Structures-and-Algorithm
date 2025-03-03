import java.util.ArrayList;
import java.util.List;

public class partitionArray_2161 {
    class Solution {
        public int[] pivotArray(int[] nums, int pivot) {
            int[] smaller = new int[nums.length];
            int i = 0;
            List<Integer> greater = new ArrayList<>();
            int countEqual = 0;
            for(int num : nums){
                if(num < pivot){
                    smaller[i] = num;
                    i++;
                }else if(num > pivot){
                    greater.add(num);
                }else{
                    countEqual++;
                }
            }
            while(countEqual!=0){
                smaller[i] = pivot;
                countEqual--;
                i++;
            }
            for(int j = 0; j<greater.size(); j++){
                smaller[i] = greater.get(j);
                i++;
            }
            return smaller;
        }
    }
}
