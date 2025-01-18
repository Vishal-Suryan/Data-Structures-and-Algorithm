import java.util.Stack;

public class maximalRectangle {
    class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[][] preSum=new int[matrix.length][matrix[0].length];
        for(int j=0;j<matrix[0].length;j++){
            int sum=0;
            for(int i=0;i<matrix.length;i++){
                sum+=matrix[i][j]-'0';
                if(matrix[i][j]=='0'){
                    sum=0;
                }
                preSum[i][j]=sum;
            }
        }
        int maxRect=0;
        for(int i=0;i<matrix.length;i++){
            maxRect=Math.max(maxRect,largestRectangle(preSum[i]));
        }
        return maxRect;
    }
    private int largestRectangle(int[] nums){
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && (nums[st.peek()])>(nums[i])){
                int element=st.pop();
                int nse=i;
                int pse=(st.isEmpty())?-1:st.peek();
                maxArea=Math.max(maxArea,nums[element]*(nse-pse-1));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int nse=nums.length;
            int element=st.pop();
            int pse=(st.isEmpty())?-1:st.peek();
            maxArea=Math.max(maxArea,nums[element]*(nse-pse-1));
        }
        return maxArea;
    }
}
}
