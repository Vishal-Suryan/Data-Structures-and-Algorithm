import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class alienLanguage {
    class Solution {
    public String findOrder(String[] words) {
        // code here
        Set<Character> uniqueChars = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                uniqueChars.add(c);
            }
        }
        int K = uniqueChars.size();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<26; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<words.length - 1; i++){
            String str1 = words[i];
            String str2 = words[i + 1];
            int len = Math.min(str1.length(), str2.length());
            for(int j = 0; j<len; j++){
                if(str1.charAt(j) != str2.charAt(j)){
                    adj.get(str1.charAt(j) - 'a').add(str2.charAt(j) - 'a');
                    break;
                }
            }
        }
        ArrayList<Integer> topo = topologicalSort(K,adj);
        if(topo.size() != K) return "";
        String ans = "";
        for (int it : topo) {
            ans = ans + (char)(it + (int)('a'));
        }
        return ans;
    }
    private  ArrayList<Integer> topologicalSort(int n,ArrayList<ArrayList<Integer>> adj) {
        //int n = adj.size();
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
