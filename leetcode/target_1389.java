import java.util.ArrayList;
public class target_1389 {
    class Solution {
        public int[] createTargetArray(int[] nums, int[] index) {
            ArrayList<Integer> target=new ArrayList<>();
            int j=0;
            for(int i=0;i<nums.length;i++){
                target.add(index[i],nums[i]);
            }
            for(int i=0;i<nums.length;i++){
                nums[i]=target.get(i);
            }
            return nums;
        }
    }
}
