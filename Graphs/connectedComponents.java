import java.util.ArrayList;
import java.util.Collections;
/* import java.util.LinkedList;
import java.util.Queue; */

public class connectedComponents {
    class Solution {
        public ArrayList<ArrayList<Integer>> connectedcomponents(int v, int[][] edges) {
            ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i < v; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                int src = edge[0];
                int dest = edge[1];
                adjList.get(src).add(dest);
                adjList.get(dest).add(src);
            }
            
            boolean[] visited = new boolean[v];
            ArrayList<ArrayList<Integer>> components = new ArrayList<>();
            for (int i = 0; i < v; i++) {
                if (!visited[i]) {
                    ArrayList<Integer> component = new ArrayList<>();
                    dfs(i, adjList, visited, component);
                    Collections.sort(component);
                    components.add(component);
                }
            }
            return components;
        }
/*         private void bfs(int start, ArrayList<ArrayList<Integer>> adjList, 
        boolean[] visited, ArrayList<Integer> component) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            visited[start] = true;
            while (!queue.isEmpty()) {
                int node = queue.poll();
                component.add(node);
                for (int neighbor : adjList.get(node)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
        } */
        private void dfs(int node, ArrayList<ArrayList<Integer>> adjList, 
        boolean[] visited, ArrayList<Integer> component) {
            visited[node] = true;
            component.add(node);
    
            for (int neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                    dfs(neighbor, adjList, visited, component);
                }
            }
        }
    }
}
