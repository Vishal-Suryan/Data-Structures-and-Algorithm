import java.util.Map;
import java.util.TreeMap;

public class relativeSort_1122 {
    class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer>mp=new TreeMap<>();
        for(int i=0;i<arr1.length;i++){
            mp.put(arr1[i],mp.getOrDefault(arr1[i],0)+1);
        }
        int j=0;
        for(int key:arr2){
            int count=mp.get(key);
            while(count>0){
                arr1[j]=key;
                count--;
                j++;
            }
            mp.put(key,0);
        }
        for(int key:mp.keySet()){
            int count=mp.get(key);
            while(count>0){
                arr1[j]=key;
                count--;
                j++;
            }
        }
        
        return arr1;
    }
}
}
