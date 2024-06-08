import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum {
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res=new ArrayList<>();
            Arrays.sort(nums);
            for(int i=0;i<nums.length;i++){
                if(i!=0 && nums[i]==nums[i-1]){
                    continue;
                }
                for(int j=i+1;j<nums.length;j++){
                    if(j>i+1 && nums[j]==nums[j-1]){
                        continue;
                    }
                    int k=j+1;
                    int m=nums.length-1;
                    while(k<m){
                        long sum = nums[i];
                        sum += nums[j];
                        sum += nums[k];
                        sum += nums[m];
                        if(sum==target){
                            List<Integer> temp=Arrays.asList(nums[i],nums[j],nums[k],nums[m]);
                            res.add(temp);
                            k++;
                            m--;
                            while(k<m && nums[k]==nums[k-1]){
                                k++;
                            }
                            while(k<m && nums[m]==nums[m+1]){
                                m--;
                            }
                        }else if(sum<target){
                            k++;
                        }else{
                            m--;
                        }
                    }
                }
            }
            return res;
        }
    }
}
