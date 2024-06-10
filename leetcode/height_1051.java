public class height_1051 {
    class Solution {
        public int heightChecker(int[] heights) {
            int[]countHash=new int[101];
            for(int i=0;i<heights.length;i++){
                countHash[heights[i]]++;
            }
            int[] temp=new int[heights.length];
            int j=0;
            for(int i=1;i<101;i++){
                if(countHash[i]!=0){
                    while(countHash[i]>0){
                        temp[j]=i;
                        countHash[i]--;
                        j++;
                    }
                }
            }
            int count=0;
            for(int i=0;i<heights.length;i++){
                if(temp[i]!=heights[i]){
                    count++;
                }
            }
            return count;
        }
    }
}
