import java.util.ArrayList;
import java.util.List;

public class majority2 {
    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            int count1 =0;
            int count2 =0;
            List<Integer> res=new ArrayList<>();
            int ele1 =Integer.MIN_VALUE;
            int ele2 =Integer.MIN_VALUE;
            for(int i=0;i<nums.length;i++){
                if(count1==0 && nums[i]!=ele2){
                    count1=1;
                    ele1=nums[i];
                }else if(count2==0 && nums[i]!=ele1){
                    count2=1;
                    ele2=nums[i];
                }else if(ele1==nums[i]){
                    count1++;
                }else if(ele2==nums[i]){
                    count2++;
                }else{
                    count1--;
                    count2--;
                }
            }
            count1=0;
            count2=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==ele1){
                    count1++;
                }
                if(nums[i]==ele2){
                    count2++;
                }
            }
            int min= nums.length/3;
            if(count1>min){
                res.add(ele1);
            }
            if(count2>min){
                res.add(ele2);
            }
            return res;
        }
    }
}
