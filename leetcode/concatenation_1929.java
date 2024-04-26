class concatenation_1929 {
    public int[] getConcatenation(int[] nums) {
        int[] array=new int[2*nums.length];
        for(int i=0;i<nums.length;i++){
            array[i]=nums[i];
        }
        int j=0;
        for(int i=nums.length;i<2*nums.length;i++){
            array[i]=nums[j];
            j++;

        }
        return array;
    }
}