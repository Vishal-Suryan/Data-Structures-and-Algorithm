import java.util.Stack;

public class stockSpan {
    class StockSpanner {
    class Pair{
        int val;
        int key;
        Pair(int _key, int _val){
            key = _key;
            val = _val;
        }
        public int getKey(){
            return this.key;
        }
        public int getValue(){
            return this.val;
        }
    }
    Stack<Pair> mystack = new Stack<>();
    public StockSpanner() {
        
    }
    public int next(int price){
        if(mystack.size() == 0){
            mystack.push(new Pair(price, 1));
            return 1;         
        }else{
            int count = 0;
            while(mystack.size() != 0 && mystack.peek().getKey() <= price){
                Pair tempVal = mystack.pop();
                count += tempVal.getValue();
            }
            mystack.push(new Pair(price, count + 1));
            return count + 1;
        }
                                   
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
}
