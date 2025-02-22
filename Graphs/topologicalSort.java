import java.util.*;
public class topologicalSort {
    class Solution {
        // Function to return list containing vertices in Topological order.
        static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
            // Your code here
            ArrayList<Integer> res = new ArrayList<>();
            Stack<Integer> st = new Stack<>();
            boolean[] vis = new boolean[adj.size()];
            for(int i = 0; i<adj.size(); i++){
                if(!vis[i]){
                    dfs(i, adj, vis, st);
                }
            }
            while(!st.isEmpty()){
                res.add(st.pop());
            }
            return res;
        }
        private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, 
        Stack<Integer> st){
            vis[node] = true;
            for(int adjacent : adj.get(node)){
                if(!vis[adjacent]){
                    dfs(adjacent, adj, vis, st);
                }
            }
            st.push(node);
            return;
        }
    }
}
