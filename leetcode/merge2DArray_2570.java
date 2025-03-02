import java.util.TreeMap;

public class merge2DArray_2570 {
    class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int[] num : nums1){
            int i = num[0];
            int j = num[1];
            map.put(i,j);
        }
        for(int[] num : nums2){
            int i = num[0];
            int j = num[1];
            map.put(i,map.getOrDefault(i,0)+j);
        }
        int n = map.size();
        int[][] res = new int[n][2];
        int i = 0;
        for(int num : map.keySet()){
            int val = map.get(num);
            res[i][0] = num;
            res[i][1] = val;
            i++;
        }
        return res;
    }
}
}
