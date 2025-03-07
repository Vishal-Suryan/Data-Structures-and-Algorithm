import java.util.ArrayList;

public class closetPrimeRange_2523 {
    class Solution {
        // Brute Force Approach
        public int[] closestPrimes(int left, int right) {
            int num1 = 0;
            int num2 = 0;
            int difference = Integer.MAX_VALUE;
            ArrayList<Integer> prime = primeInRange(left, right);
            if(prime.size() < 2) return new int[]{-1, -1};
            for(int i = 0; i<prime.size() - 1; i++){
                if(prime.get(i + 1) - prime.get(i) < difference){
                    num1 = prime.get(i);
                    num2 = prime.get(i + 1);
                    difference  = prime.get(i + 1) - prime.get(i);
                }
            }
            return new int[]{num1,num2};
        }
        private ArrayList<Integer> primeInRange(int start, int end){
            ArrayList<Integer> res = new ArrayList<>();
            for(int i = start; i<=end; i++){
                if(checkPrime(i)){
                    res.add(i);
                }
            }
            return res;
        }
        private boolean checkPrime(int num){
            if(num == 1 || num == 0){
                return false;
            }
            for(int i = 2; i*i <= num; i++){
                if(num % i == 0){
                    return false;
                }
            }
            return true;
        }
    }
}
