public class nextGreaterElement1 {
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] stack=new int[1001];
            int top=-1;
            int[] hash=new int[10001];
            for(int i=nums2.length-1;i>=0;i--){
                int val=nums2[i];
                while(top!=-1 && val>=stack[top]){
                    top--;
                }
                hash[val]=(top== -1)? -1:stack[top];
                stack[++top]=val;
            }
            for(int i=0;i<nums1.length;i++){
                nums1[i]=hash[nums1[i]];
            }
            return nums1;
        }
    }
}
