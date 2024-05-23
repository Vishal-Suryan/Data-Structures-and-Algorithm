import java.util.ArrayList;
import java.util.Collections;

public class leader {
    class Solution{
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        int max=arr[arr.length-1];
        ans.add(max);
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]>=max){
                max=arr[i];
                ans.add(arr[i]);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
}
