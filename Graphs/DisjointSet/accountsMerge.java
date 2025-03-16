package DisjointSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class accountsMerge {
    class Solution {
    public class DisjointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        DisjointSet(int n){
            for(int i = 0; i<=n; i++){
                rank.add(0);
                parent.add(i);
                size.add(1);
            }
        }
        public int find(int node){
            if(node == parent.get(node)){
                return node;
            }
            int ultimateParent = find(parent.get(node));
            parent.set(node,ultimateParent);
            return parent.get(node);
        }

        public void unionBySize(int x, int y){
            int parentX = find(x);
            int parentY = find(y);
            if(parentX == parentY) return;
            if (size.get(parentX) < size.get(parentY)) { // Attaching smaller tree X to Y
                parent.set(parentX, parentY);
                size.set(parentY, size.get(parentY) + size.get(parentX));
            } else {
                parent.set(parentY, parentX); // Attaching smaller tree Y to X
                size.set(parentX, size.get(parentX) + size.get(parentY));
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        Map<String,Integer> mapMailNode = new HashMap<>();
        for(int i = 0; i<n; i++){
            for(int j = 1; j<accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);
                if(!mapMailNode.containsKey(mail)){
                    mapMailNode.put(mail, i);
                }else{
                    ds.unionBySize(i, mapMailNode.get(mail));
                }
            }
        }
        ArrayList<String>[] mergedMail = new ArrayList[n];
        for(int i = 0; i<n; i++){
            mergedMail[i] = new ArrayList<String>();
        }
        for(Map.Entry<String,Integer> itr : mapMailNode.entrySet()){
            String mail = itr.getKey();
            int node = ds.find(itr.getValue());
            mergedMail[node].add(mail);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i<n; i++){
            if(mergedMail[i].size() == 0) continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String str : mergedMail[i]){
                temp.add(str);
            }
            ans.add(temp);
        }
        return ans;
    }
}
}
