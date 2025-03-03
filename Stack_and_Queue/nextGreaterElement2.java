import java.util.Stack;

public class nextGreaterElement2 {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            Stack<Integer> st=new Stack<>();
            int len=nums.length;
            int[] ans=new int[len];
            for(int i=2*len-1;i>=0;i--){
                while(!st.isEmpty() && st.peek()<=nums[i%len]){
                    st.pop();
                }
                if(i<len){
                    if(st.isEmpty()){
                        ans[i]=-1;
                    }else{
                        ans[i]=st.peek();
                    }
                }
                st.push(nums[i%len]);
            }
            return ans;
        }
    }
}
