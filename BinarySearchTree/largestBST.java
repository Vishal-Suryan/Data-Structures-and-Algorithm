public class largestBST {
    class Node{
        int data;
        Node left,right;
        
        Node(int key)
        {
            data = key;
            left = right = null;
        }
    }
    static class NodeValue{
        public int minNode,maxNode,maxSize;
        NodeValue(int minNode,int maxNode,int maxSize){
            this.minNode=minNode;
            this.maxNode=maxNode;
            this.maxSize=maxSize;
        }
    }
    class Solution{
        
        // Return the size of the largest sub-tree which is also a BST
        static int largestBst(Node root)
        {
            // Write your code here
            return helper(root).maxSize;
            
        }
        private static NodeValue helper(Node root){
            if(root==null){
                return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
            }
            NodeValue left=helper(root.left);
            NodeValue right=helper(root.right);
            if(left.maxNode < root.data && root.data<right.minNode){
                return new NodeValue(Math.min(root.data,left.minNode)
                    ,Math.max(root.data,right.maxNode),1+left.maxSize+right.maxSize);
            }
            return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE
                ,Math.max(left.maxSize,right.maxSize));
        }
    }
}