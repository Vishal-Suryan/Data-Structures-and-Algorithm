import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
public class nodesAtDistanceK {
    class Solution {
        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            Map<TreeNode,TreeNode> parentNodeMap=new HashMap<>();
            Queue<TreeNode> q=new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()){
                int size=q.size();
                for(int i=0;i<size;i++){
                    TreeNode curr=q.poll();
                    if(curr.left!=null){
                        q.offer(curr.left);
                        parentNodeMap.put(curr.left,curr);
                    } 
                    if(curr.right!=null){
                        q.offer(curr.right);
                        parentNodeMap.put(curr.right,curr);
                    }
                }  
            }
            Map<TreeNode,Boolean> isVisited=new HashMap<>();
            q.offer(target);
            isVisited.put(target,true);
            int dist=0;
            while(!q.isEmpty()){
                int size=q.size();
                if(dist==k) break;
                dist++;
                for(int i=0;i<size;i++){
                    TreeNode curr=q.poll();
                    if(curr.left!=null && isVisited.get(curr.left)==null){
                        isVisited.put(curr.left,true);
                        q.offer(curr.left);
                    }
                    if(curr.right!=null && isVisited.get(curr.right)==null){
                        isVisited.put(curr.right,true);
                        q.offer(curr.right);
                    }
                    if(parentNodeMap.get(curr)!=null && 
                        isVisited.get(parentNodeMap.get(curr))==null){
                        isVisited.put(parentNodeMap.get(curr),true);
                        q.offer(parentNodeMap.get(curr));
                    }
                }
            }
            ArrayList<Integer> ans=new ArrayList<>();
            while(!q.isEmpty()){
                ans.add(q.poll().val);
            }
            return ans;
        }
    }
}
