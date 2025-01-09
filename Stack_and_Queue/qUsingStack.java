import java.util.Stack;

public class qUsingStack {
    class MyQueue {
        private Stack<Integer> st;
        private Stack<Integer> helper;
        public MyQueue() {
            st=new Stack<>();
            helper=new Stack<>();
        }
        
        public void push(int x) {
            st.push(x);
        }
        public int pop() {
            if (helper.isEmpty()) {
                while (!st.isEmpty()) {
                    helper.push(st.pop());
                }
            }
            return helper.pop();
        }
    
        public int peek() {
            if (helper.isEmpty()) {
                while (!st.isEmpty()) {
                    helper.push(st.pop());
                }
            }
            return helper.peek();
        }
    
        public boolean empty() {
            return st.isEmpty() && helper.isEmpty();
        }
        
    /*     public int pop() {
            while(!st.isEmpty()){
                helper.push(st.pop());
            }
            int element=helper.pop();
            while(!helper.isEmpty()){
                st.push(helper.pop());
            }
            return element;
        }
        
        public int peek() {
            while(!st.isEmpty()){
                helper.push(st.pop());
            }
            int element=helper.peek();
            while(!helper.isEmpty()){
                st.push(helper.pop());
            }
            return element;
        }
        
        public boolean empty() {
            return st.isEmpty();
        } */
    }
    
    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
}
