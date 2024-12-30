import java.util.ArrayList;
import java.util.Stack;

public class boundaryTraversal {
    class Node{
        int data;
        Node left, right;
        public Node(int d){
            data = d;
            left = right = null;
        }
    }
    class Solution {
        ArrayList<Integer> boundaryTraversal(Node node) {
            // code here
            ArrayList<Integer> ans=new ArrayList<>();
            if(node==null) return ans;
            ans.add(node.data);
            if(isLeaf(node)) return ans;
            leftBoundary(node,ans);
            leafNodes(node,ans);
            rightBoundary(node,ans);
            return ans;
        }
        public static boolean isLeaf(Node node){
            if(node.left == null && node.right==null){
                return true;
            }
            return false;
        }
        private static void leftBoundary(Node node,ArrayList<Integer> ans){
            Node curr = node.left;
            while(curr!=null){
                if(!isLeaf(curr)){
                    ans.add(curr.data);
                }
                if(curr.left!=null){
                    curr=curr.left;
                }else{
                    curr=curr.right;
                }
            }
            return;
        }
        private static void rightBoundary(Node node,ArrayList<Integer> ans){
            Stack<Node> st= new Stack<>();
            Node curr = node.right;
            while(curr!=null){
                if(!isLeaf(curr)){
                    st.push(curr);
                }
                if(curr.right!=null){
                    curr=curr.right;
                }else{
                    curr=curr.left;
                }
            }
            while(!st.isEmpty()){
                ans.add(st.pop().data);
            }
            return;
        }
        private static void leafNodes(Node node,ArrayList<Integer> ans){
            if(isLeaf(node)){
                ans.add(node.data);
                return;
            }
            if(node.left!=null){
                leafNodes(node.left,ans);
            }
            if(node.right!=null){
                leafNodes(node.right,ans);
            }
        }
    }
}