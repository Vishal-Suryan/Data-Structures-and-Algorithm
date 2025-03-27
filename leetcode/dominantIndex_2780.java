import java.util.List;

public class dominantIndex_2780 {
    class Solution {
    public int minimumIndex(List<Integer> nums) {
        int dominant = findDominant(nums);
        if(dominant == -1) return -1;
        int leftDominantCount = 0;
        int totalDominantCount = 0;
        for(int num : nums){
            if(num == dominant) totalDominantCount++;
        }
        for(int i = 0; i<nums.size() - 1; i++){
            if(nums.get(i) == dominant){
                leftDominantCount++;
            }
            int leftSubarrayCount = leftDominantCount;
            int rightSubarrayCount = totalDominantCount - leftDominantCount;
            if(leftSubarrayCount > (i + 1) / 2 && rightSubarrayCount > (nums.size() - i - 1) / 2){
                return i;
            }
        }
        return -1;
    }
    private int findDominant(List<Integer> nums){
        int temp = -1;
        int count = 0;
        for(int num : nums){
            if(count == 0){
                temp = num;
                count = 1;
            }else if(num == temp){
                count++;
            }else{
                count--;
            }
        }
        int totalCount = 0;
        for(int num : nums){
            if(num == temp) totalCount++;
        }
        return (totalCount > nums.size() / 2) ? temp : -1;
    }
}
}
