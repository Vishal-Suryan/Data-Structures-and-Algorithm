import java.util.ArrayDeque;
import java.util.Deque;

public class slidingWindowMax {
    class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /* int[] res=new int[nums.length-k+1];
        for(int i=0;i<=nums.length-k;i++){
            int max=nums[i];
            for(int j=i;j<i+k;j++){
                max=Math.max(max,nums[j]);
            }
            res[i]=max;
        }
        return res; */
        int[] res=new int[nums.length-k+1];
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            if(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(i>=k-1){
                res[i-k+1] = nums[dq.peekFirst()];
            }
        }
        return res;
    }
}
}
