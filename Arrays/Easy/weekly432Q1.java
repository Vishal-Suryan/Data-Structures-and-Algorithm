import java.util.ArrayList;
import java.util.List;

public class weekly432Q1 {
    class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> ans=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        boolean flag=true; 
        for(int i=0;i<grid.length;i++){
            if(flag){
                for(int j=0;j<grid[1].length;j++){
                    ans.add(grid[i][j]);
                }
            }else{
                for(int j=grid[1].length-1;j>=0;j--){
                    ans.add(grid[i][j]);
                }
            }
            flag=!flag;
        }
        for(int i=0;i<ans.size();i+=2){
            res.add(ans.get(i));
        }
        return res;
    }
}
}
