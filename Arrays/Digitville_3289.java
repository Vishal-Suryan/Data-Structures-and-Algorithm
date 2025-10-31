class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        int[] hash = new int[n - 2];
        int[] ans = new int[2];
        int i = 0;
        for(int num : nums){
            if(hash[num] == 0){
                hash[num]++;
            }else{
                ans[i++] = num;
            }
        }
        return ans;
    }
}