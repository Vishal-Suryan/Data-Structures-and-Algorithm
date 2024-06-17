import java.util.Arrays;

public class magnetic_1552 {
    class Solution {
    static boolean possible(int[] position ,int d,int balls){
        int countBall=1;
        int last=position[0];
        for(int i=1;i<position.length;i++){
            if(position[i]-last>=d){
                countBall++;
                last=position[i];
            }
            if(countBall>=balls){
                return true;
            }
        }
        return false;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low=0;
        int high=position[position.length-1]-position[0];
        while(low<=high){
            int mid=(low+high)/2;
            if((possible(position,mid,m))==false){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return high;
    }
}
}
