public class qUsingArray {
    class MyQueue {

        int front, rear;
        int arr[] = new int[100005];
    
        MyQueue()
        {
            front=0;
            rear=0;
        }
        
        //Function to push an element x in a queue.
        void push(int x)
        {
            // Your code here
            arr[front]=x;
            front++;
        } 
    
        //Function to pop an element from queue and return that element.
        int pop()
        {
            // Your code here
            if(front==0 || front<=rear) return -1;
            int temp=arr[rear];
            arr[rear]=0;
            rear++;
            return temp;
        } 
    }
    
}
