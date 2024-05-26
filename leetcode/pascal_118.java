import java.util.ArrayList;
import java.util.List;

public class pascal_118 {
    class Solution {
        public static List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ans= new ArrayList<>();
            for (int i=1;i<=numRows;i++){
                ans.add(generateRow(i));
            }
            return ans;
        }
        public static List<Integer> generateRow(int row){
            long ans=1;
            List<Integer> temp= new ArrayList<>();
            temp.add(1);
            for(int i=1;i<row;i++){
                ans=ans*(row-i);
                ans=ans/i;
                temp.add((int)ans);
            }
            return temp;
        }
    }
}
