class diff_389{
    class Solution {
        public char findTheDifference(String s, String t) {
            int sum1=0 , sum2=0;
            for(char chr:s.toCharArray()){
                sum1+=chr;
            }
            for(char chr:t.toCharArray()){
                sum2+=chr;
            }
            
            return (char)(sum2-sum1);
        }
    }
}