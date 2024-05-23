import java.util.Arrays;

public class longestSubSeq_128 {
    public static int longestConsecutive2(int[] nums) { //Better Approach TC= O(NlogN )+ O(N)
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int maxCount=1;
        int lastSmaller=Integer.MIN_VALUE;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]-1 == lastSmaller){
                lastSmaller=nums[i];
                count++;
            }else if(nums[i]!=lastSmaller){
                count=1;
                lastSmaller=nums[i];
            }
            maxCount=Math.max(maxCount,count);
        }
        return maxCount;
    }
}
