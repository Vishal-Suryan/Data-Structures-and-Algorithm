import java.util.ArrayList;

public class dfs {
    class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited=new boolean[adj.size()];
        ArrayList<Integer> res=new ArrayList<>();
        visited[0]=true;
        dfs(adj,0,visited,res);
        return res;
    }
    void dfs(ArrayList<ArrayList<Integer>> adj,int node,boolean[] visited,
    ArrayList<Integer> res){
        visited[node]=true;
        res.add(node);
        for(Integer itr:adj.get(node)){
            if(visited[itr]==false){
                dfs(adj,itr,visited,res);
            }
        }
        return;
    }
}
}
