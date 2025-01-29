import java.util.ArrayList;
import java.util.List;

public class adjacencyMatrix {
    class Solution {
        public List<List<Integer>> printGraph(int V, int edges[][]) {
            List<List<Integer>> res=new ArrayList<>();
            for(int i=0;i<V;i++){
                res.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                int src = edge[0];
                int dest = edge[1];
                res.get(src).add(dest);
                res.get(dest).add(src);
            }
            return res;
        }
    }
}
