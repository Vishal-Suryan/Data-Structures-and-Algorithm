public class bfs {
    class Solution {
        // Function to return Breadth First Traversal of given graph.
        public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
            // code here
            int startingNode = V;
            Queue<Integer> q=new LinkedList<>();
            boolean[] visited=new boolean[V];
            ArrayList<Integer> bfs=new ArrayList<>();
            q.add(0);
            visited[0]=true;
            while(!q.isEmpty()){
                int node=q.poll();
                bfs.add(node);
                for(Integer list:adj.get(node)){
                    if(visited[list]==false){
                        visited[list]=true;
                        q.offer(list);
                    }
                }
            }
            return bfs;
        }
    }
}
