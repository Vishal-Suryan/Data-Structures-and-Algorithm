import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class alienLanguageUpdated {
    class Solution {
    public String findOrder(String[] words) {
        Set<Character> uniqueChars = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                uniqueChars.add(c);
            }
        }
        int K = uniqueChars.size(); // Unique characters count
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        // Initialize adjacency list and in-degree count
        for (char c : uniqueChars) {
            adj.put(c, new ArrayList<>());
            inDegree.put(c, 0);
        }

        // Build adjacency list based on character precedence
        for (int i = 0; i < words.length - 1; i++) {
            String str1 = words[i];
            String str2 = words[i + 1];
            int len = Math.min(str1.length(), str2.length());
            boolean found = false;
            
            for (int j = 0; j < len; j++) {
                if (str1.charAt(j) != str2.charAt(j)) {
                    char u = str1.charAt(j);
                    char v = str2.charAt(j);
                    if (!adj.get(u).contains(v)) {
                        adj.get(u).add(v);
                        inDegree.put(v, inDegree.get(v) + 1);
                    }
                    found = true;
                    break;
                }
            }

            // If no different character found and str1 is longer, return ""
            if (!found && str1.length() > str2.length()) {
                return "";
            }
        }

        return topologicalSort(K, adj, inDegree);
    }

    private String topologicalSort(int n, Map<Character, List<Character>> adj, Map<Character, Integer> inDegree) {
        Queue<Character> q = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) {
                q.offer(c);
            }
        }

        while (!q.isEmpty()) {
            char node = q.poll();
            result.append(node);

            for (char neighbor : adj.get(node)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    q.offer(neighbor);
                }
            }
        }

        // If the result size doesn't match the unique character count, return ""
        return (result.length() == n) ? result.toString() : "";
    }
    
}
}
