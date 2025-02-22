import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class courseSchedule2 {
    class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        return topologicalSort(numCourses, prerequisites);
    }
    private int[] topologicalSort(int n, int[][] pre){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        int m = pre.length;
        for(int i = 0; i<m; i++){
            adj.get(pre[i][1]).add(pre[i][0]);
        }
        int[] inDegree = new int[n];
        for(int i = 0; i<n; i++){
            for(int itr : adj.get(i)){
                inDegree[itr]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            if(inDegree[i] == 0) q.offer(i);
        }
        ArrayList<Integer> temp = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            temp.add(node);
            for(int itr : adj.get(node)){
                inDegree[itr]--;
                if(inDegree[itr] == 0){
                    q.offer(itr);
                }
            }
        }
        if(temp.size() == n){
            int[] res = new int[temp.size()];
            for(int i = 0; i<temp.size(); i++){
                res[i] = temp.get(i);
            }
            return res;
        }
        return new int[]{};
    }
}
}
