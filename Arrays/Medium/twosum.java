import java.util.*;
public class twosum {
    public static void main(String [] args){
        int [] array={2,5,6,8,11};
        int targetSum= 14;
        System.out.println(Arrays.toString(twoSum2(array,targetSum)));
        
    }
    public static int[] twoSum(int[] nums, int targetSum){
        int[] res=new int[2];
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i+1;j<nums.length;j++){
                sum=nums[i]+nums[j];
                if(sum==targetSum){
                    res[0]=nums[i];
                    res[1]=nums[j];
                }
            }
        }
        return res;
    }
    public static int[] twoSum2(int[] nums, int targetSum){
        //works but time limit gets exceeded for very large input of array
        int[] res=new int[2];
        Arrays.sort(nums);
        int right=nums.length-1;
        int left=0;
        while(left<right){
            int sum=nums[left]+nums[right];
            if(sum==targetSum){
                res[0]=nums[left];
                res[1]=nums[right];
            }else if(sum<targetSum){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
    

}
