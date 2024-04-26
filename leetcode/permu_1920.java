public class permu_1920 {
    public int[] buildArray(int[] nums) {
        int[] hash=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            hash[i]=nums[nums[i]];
        }
        return hash;
    }

}
