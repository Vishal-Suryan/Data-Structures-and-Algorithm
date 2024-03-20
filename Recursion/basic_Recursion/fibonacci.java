public class fibonacci {
    static int fibonacci(int N){
            if(N <= 1){
                return N;
            }
            return fibonacci(N-1)+fibonacci(N-2);
    }
    //program for getting nth fibonacci number
        public static void main(String[] args) {
           int N = 2;
           System.out.println(fibonacci(N));
        }
    }