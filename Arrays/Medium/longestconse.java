import java.util.Arrays;
import java.util.HashSet;

public class longestconse {
    public static int longestConsecutive(int[] nums) { // Brute force solution TC= O(N^2)
        if(nums.length==0){
            return 0;
        }
        int maxCount=1;
        for(int i=0;i<nums.length;i++){
            int count=1;
            int x=nums[i];
            while(linearSearch(nums,x+1)==1){
                x++;
                count++;
            }
            maxCount=Math.max(maxCount,count);
        }
        return maxCount;
    }
    static int linearSearch(int[] nums,int num){
        for(int i=0;i<nums.length;i++){
            if(nums[i]==num){
                return 1;
            }
        }
        return 0;
    }  
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
    public static int longestConsecutive3(int[] nums) { // TC= O(3*N) && SC = O(N)
        if(nums.length==0){
            return 0;
        }
        HashSet<Integer> set= new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int maxCount=1;
        for(int itr: set){
            if(!set.contains(itr-1)){
                int count =1;
                int x=itr;
                while(set.contains(x+1)){
                    count++;
                    x++;
                }
                maxCount=Math.max(maxCount,count);
            }
        }
        return maxCount;
    }
    public static void main(String[] args){
        int[] arr={0,-1};
        System.out.println(longestConsecutive(arr));
    }
}
