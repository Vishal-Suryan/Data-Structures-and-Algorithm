import java.util.LinkedList;
import java.util.Queue;
public class serializeDeserialize {
    public class Codec {
        public static class TreeNode {
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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        Queue<TreeNode> q=new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr==null){
                sb.append("# ");
                continue;
            }
            sb.append(curr.val+" ");
            q.offer(curr.left);
            q.offer(curr.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="") return null;
        Queue<TreeNode> q=new LinkedList<>();
        String[] str=data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(str[0]));
        q.offer(root);
        for(int i=1;i<str.length;i++){
            TreeNode parent=q.poll();
            if(!str[i].equals("#")){
                TreeNode left=new TreeNode(Integer.parseInt(str[i]));
                parent.left=left;
                q.offer(left);
            }
            if(!str[++i].equals("#")){
                TreeNode right=new TreeNode(Integer.parseInt(str[i]));
                parent.right=right;
                q.offer(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}
