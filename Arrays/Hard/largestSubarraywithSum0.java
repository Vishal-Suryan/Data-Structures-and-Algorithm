import java.util.HashMap;
import java.util.Map;

public class largestSubarraywithSum0 {
    class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        Map<Integer,Integer> mp=new HashMap<>();
        int sum=0;
        int max=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==0){
                max=i+1;
            }else{
                if(mp.get(sum)!=null){
                    max=Math.max(max,i-mp.get(sum));
                }else{
                    mp.put(sum,i);
                }
            }
        }
        return max;
    }
}
}
