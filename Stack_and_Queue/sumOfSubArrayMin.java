import java.util.Stack;

public class sumOfSubArrayMin {
    /* ----------BRUTE FORCE -------- O(N^2) = TC
    class Solution {
        public int sumSubarrayMins(int[] arr) {
            long sum=0;
            long mod = (int)Math.pow(10,9)+7;
            for(int i=0;i<arr.length;i++){
                int min=arr[i];
                for(int j=i;j<arr.length;j++){
                    min=Math.min(min,arr[j]);
                    sum=(sum+min)%mod;
                }
            }
            return (int)sum;
        }
    } */
   class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] nextSmaller=nse(arr);
        int[] prevSmaller=pse(arr);
        double mod=Math.pow(10,9)+7;
        double sum=0;
        for(int i=0;i<arr.length;i++){
            int left=i-prevSmaller[i];
            int right=nextSmaller[i]-i;
            sum=(sum+((((left*right)%mod)*arr[i])%mod))%mod;
        }
        return (int) sum;
    }
    private int[] nse(int[] nums){
        Stack<Integer> st=new Stack<>();
        int[] res=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            res[i]=(st.isEmpty())?nums.length:st.peek();
            st.push(i);
        }
        return res;
    }
    private int[] pse(int[] nums){
        Stack<Integer> st=new Stack<>();
        int[] res=new int[nums.length];
        for(int i=0; i<nums.length;i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                st.pop();
            }
            res[i]=(st.isEmpty())? -1:st.peek();
            st.push(i);
        }
        return res;
    }
}
}
