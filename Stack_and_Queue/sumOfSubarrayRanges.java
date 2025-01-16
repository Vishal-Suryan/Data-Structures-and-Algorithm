import java.util.Stack;

public class sumOfSubarrayRanges {
    class Solution {
        public long subArrayRanges(int[] nums) {
            double rangeSum = 0;
            for (int i = 0; i < nums.length; i++) {
                int min = nums[i];
                int max = nums[i];
                for (int j = i; j < nums.length; j++) {
                    min = Math.min(min, nums[j]);
                    max = Math.max(max, nums[j]);
                    rangeSum += (max - min);
                }
            }
    
            return (long)rangeSum;
        }
    }
    class Solution1 {
    public long subArrayRanges(int[] arr) {
        long minSum=subArrayMin(arr);
        long maxSum=subArrayMax(arr);
        return  maxSum-minSum;
    }
    
    public long subArrayMin(int arr[]){
        int pse[]=findPSE(arr);
        int nse[]=findNSEE(arr);
        long total=0;
        for(int i=0;i<arr.length;i++){
            int currpse=i-pse[i];
            int currnse=nse[i]-i;
            total+=(long)currpse*currnse*arr[i];
        }
        return total;
    }

    public int[] findPSE(int arr[]){
        Stack<Integer> stack=new Stack<>();
        int res[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                stack.pop();
            }
            res[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        return res;
    }

    public int[] findNSEE(int arr[]){
        Stack<Integer> stack=new Stack<>();
        int res[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            res[i]=stack.isEmpty()?arr.length:stack.peek();
            stack.push(i);
        }
        return res;
    }

    //pge and nge
    public long subArrayMax(int arr[]){
        int pge[]=findPGE(arr);
        int nge[]=findNGEE(arr);
        long total=0;
        for(int i=0;i<arr.length;i++){
            int currpge=i-pge[i];
            int currnge=nge[i]-i;
            total+=(long)currpge*currnge*arr[i];
        }
        return total;
    }

    public int[] findPGE(int arr[]){
        Stack<Integer> stack=new Stack<>();
        int res[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peek()]<arr[i]){
                stack.pop();
            }
            res[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        return res;
    }

    public int[] findNGEE(int arr[]){
        Stack<Integer> stack=new Stack<>();
        int res[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]){
                stack.pop();
            }
            res[i]=stack.isEmpty()?arr.length:stack.peek();
            stack.push(i);
        }
        return res;
    }
}
    
}
