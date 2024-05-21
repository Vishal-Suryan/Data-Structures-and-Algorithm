import java.util.HashMap;
import java.util.Map;

public class subarray_sum {
    class Solution{
        // Method 1 - TC = O(N^2)
        public static int lenOfLongSubarr (int nums[], int N, int K) {
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
        // Method 2 = TC= O(NlogN)
        public static int lenOfLongSubar (int nums[], int N, int K) {
            Map<Integer,Integer> mp=new HashMap<>();
            int sum=0;
            int maxLen=0;
            for(int i=0;i<nums.length;i++){
                sum+=nums[i];
                if(sum==K){
                    maxLen=Math.max(maxLen,i+1);
                }
                int rem=sum-K;
                if(mp.containsKey(rem)){
                    int len= i - mp.get(rem);
                    maxLen=Math.max(maxLen,len);
                }
                if(!mp.containsKey(sum)){
                    mp.put(sum,i);
                }
            }
            return maxLen;
        }
        public static int lenLongSubarr (int nums[], int n, int K) {
            //Works Only if the array contains Positive Integers ===> TC = O(2*n)
            int left=0;
            int right=0;
            int sum=nums[0];
            int maxLen=0;
            while(right<n){
                while(right<n && sum>K){
                    sum-=nums[left];
                    left++;
                }
                if(sum==K){
                    maxLen=Math.max(maxLen,right-left+1);
                }
                right++;
                if(right<n){
                    sum+=nums[right];
                }
            }
            return maxLen;
        }
    }
}
