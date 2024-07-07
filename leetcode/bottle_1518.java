public class bottle_1518 {
    class Solution {
        public int numWaterBottles(int numBottles, int numExchange) {
            int ans=0;
            while(numBottles>=numExchange){
                int minExtra=numBottles/numExchange;
                ans+=numExchange * minExtra;
                numBottles-=numExchange*minExtra;
                numBottles+=minExtra;
            }
            return ans+numBottles;
        }
    }
}
