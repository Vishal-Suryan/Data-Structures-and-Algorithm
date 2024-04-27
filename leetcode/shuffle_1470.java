public class shuffle_1470 {
    class Solution {
        public int[] shuffle(int[] nums, int n) {
            int j=n;
            int k=0;
            int[] shuffle=new int[nums.length];
            for(int i=0;i<nums.length;i++){
                if(i%2==0){
                    shuffle[i]=nums[k];
                    k++;
                }else{
                    shuffle[i]=nums[j];
                    j++;
                }
            }
            return shuffle;
        }
    }
}
