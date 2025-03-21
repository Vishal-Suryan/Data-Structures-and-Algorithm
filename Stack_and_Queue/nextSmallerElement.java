import java.util.Stack;

public class nextSmallerElement {
    public class Solution {
    public int[] prevSmaller(int[] A) {
        Stack<Integer> st=new Stack<>();
        int[] res=new int[A.length];
        for(int i=0;i<A.length;i++){
            while(!st.isEmpty() && st.peek()>=A[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i]=-1;
            }else{
                res[i]=st.peek();
            }
            st.push(A[i]);
        }
        return res;
    }
}
}
