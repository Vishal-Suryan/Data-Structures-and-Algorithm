import java.util.LinkedList;
import java.util.Queue;

class stUsingLL{
    class MyStack {
        private Queue<Integer> helper;
        private Queue<Integer> q;
        public MyStack() {
            q=new LinkedList<>();
            helper=new LinkedList<>();
        }
        
        /* public void push(int x) {
            while(!q.isEmpty()){
                helper.offer(q.poll());
            }
            q.offer(x);
            while(!helper.isEmpty()){
                q.offer(helper.poll());
            }
        } */
        public void push(int x) {
            int size = q.size();
            q.offer(x); // Add the new element to the queue
    
            // Rotate the queue to make the last added element the front of the queue
            for (int i = 0; i < size; i++) {
                q.offer(q.poll());
            }
        }
        
        public int pop() {
            if(q.isEmpty()){
                throw new IllegalStateException("Stack is empty");
            }
            return q.poll();
        }
        
        public int top() {
            if(q.isEmpty()){
                throw new IllegalStateException("Stack is empty");
            }
            return q.peek();
        }
        
        public boolean empty() {
            return q.isEmpty();
        }
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */