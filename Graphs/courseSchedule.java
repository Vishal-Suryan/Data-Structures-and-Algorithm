import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class courseSchedule {
    class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return topologicalSort(numCourses, prerequisites);
    }
    private boolean topologicalSort(int n, int[][] pre){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        int m = pre.length;
        for(int i = 0; i<m; i++){
            adj.get(pre[i][0]).add(pre[i][1]);
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
        ArrayList<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            for(int itr : adj.get(node)){
                inDegree[itr]--;
                if(inDegree[itr] == 0){
                    q.offer(itr);
                }
            }
        }
        return (res.size() == n);
    }
}
}
