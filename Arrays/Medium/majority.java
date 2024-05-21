public class majority {
    public int majorityElement(int[] nums) {
        // Moore's Voting Algorithm
        int element=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                element=nums[i];
                count=1;
            }else if(element==nums[i]){
                count++;
            }else{
                count--;
            }
        }
        int count1=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==element){
                count1++;
            }
        }
        if(count1>nums.length/2){
            return element;
        }
        return -1;
    }
}
