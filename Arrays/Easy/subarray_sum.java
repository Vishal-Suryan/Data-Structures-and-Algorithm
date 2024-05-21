public class subarray_sum {
    class Solution{
        // Function for finding maximum and value pair
        public static int lenOfLongSubarr (int nums[], int N, int K) {
            //Complete the function
            int len=0;
            for(int i=0;i<N;i++){
                int sum=0;
                for(int j=i;j<N;j++){
                    sum+=nums[j];
                    if(sum==K){
                        len=Math.max(len,j-i+1);
                    }
                }
            }
            return len;
        }
    }
}
