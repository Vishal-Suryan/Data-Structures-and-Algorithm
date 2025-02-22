import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class kahnsAlgo {
    class Solution {
    // Function to return list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        int n = adj.size();
        int[] inDegree = new int[n];
        for(int i = 0; i<n; i++){
            for(int itr : adj.get(i)){
                inDegree[itr]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        //int i = 0;
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
        return res;
    }
}
}
