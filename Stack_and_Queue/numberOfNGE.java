import java.util.Stack;

public class numberOfNGE {
class Solution {
  public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
    // code here
     int[] res=new int[indices.length];
     for(int i=0;i<indices.length;i++){
         Stack<Integer> st=new Stack<>();
         for(int j=N-1;j>=indices[i]+1;j--){
             if(arr[j]>arr[indices[i]]){
                 st.push(arr[j]);
             }
         }
         res[i]=st.size();
     }
     return res;
  }
}
     
}
