import java.util.*;
public class inPrePost {
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }
    class Tree {
        class Pair<U, V> {
            private U first;
            private V second;
    
            public Pair(U first, V second) {
                this.first = first;
                this.second = second;
            }
    
            public U getKey() {
                return first;
            }
    
            public V getValue() {
                return second;
            }
    
            public void setValue(V second) {
                this.second = second;
            }
        }
    
        ArrayList<Integer> postOrder(Node node) {
            ArrayList<Integer> res = new ArrayList<>();
            if (node == null) {
                return res;
            }
    
            Stack<Pair<Node, Integer>> st = new Stack<>();
            st.push(new Pair<>(node, 1));
    
            while (!st.isEmpty()) {
                Pair<Node, Integer> it = st.pop();
    
                if (it.getValue() == 1) {
                    it.setValue(2);
                    st.push(it);
    
                    if (it.getKey().left != null) {
                        st.push(new Pair<>(it.getKey().left, 1));
                    }
                } else if (it.getValue() == 2) {
                    it.setValue(3);
                    st.push(it);
    
                    if (it.getKey().right != null) {
                        st.push(new Pair<>(it.getKey().right, 1));
                    }
                } else {
                    res.add(it.getKey().data);
                }
            }
    
            return res;
        }
    }
}
