
import java.util.*;
public class painterPartition {

public class Solution 
{
    public static int count(ArrayList<Integer> arr,int pages){
        int sum=0;
        int countStudent=1;
        for(int i=0;i<arr.size();i++){
            if(sum+arr.get(i)<=pages){
                sum+=arr.get(i);
            }else{
                countStudent++;
                sum=arr.get(i);
            }
            
        }
        return countStudent;
    }
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.
        if(m>n){
            return -1;
        }
        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();
        while(low<=high){
            int mid=(low+high)/2;
            int countStudent=count(arr,mid);
            if(countStudent>m){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;  
    }
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        //    Write your code here.
        return findPages(boards,boards.size(),k);
        
    }
}
}
