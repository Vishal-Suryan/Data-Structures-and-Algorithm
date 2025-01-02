import java.util.ArrayList;

public class rootToNodePath {
    class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}


class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        dfs(root, new ArrayList<>(), ans);
        return ans;
    }

    private static void dfs(Node node, ArrayList<Integer> nodePath, ArrayList<ArrayList<Integer>> ans) {
        if (node == null) return;
        nodePath.add(node.data);
        if (node.left == null && node.right == null) {
            ans.add(new ArrayList<>(nodePath)); 
        } else {
            dfs(node.left, nodePath, ans);
            dfs(node.right, nodePath, ans);
        }
        nodePath.remove(nodePath.size() - 1);
    }
}
}
