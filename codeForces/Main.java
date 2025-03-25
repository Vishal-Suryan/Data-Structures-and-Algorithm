import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder result = new StringBuilder();
        int MAX = 10000000; 
        boolean[] isPrime = sieve(MAX);
        while (t-- > 0) {
            int n = sc.nextInt();
            result.append(findInterestingRatios(n, isPrime)).append("\n");
        }
        System.out.print(result);
        sc.close();
    }
    private static boolean[] sieve(int max) {
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
    private static int findInterestingRatios(int n, boolean[] isPrime) {
        int count = 0;
        Map<String, Integer> gcdCache = new HashMap<>();  
        for (int a = 1; a < n; a++) {
            for (int b = a + 1; b <= n; b++) {
                int gcd = gcd(a, b, gcdCache);
                int F = (a * b) / (gcd * gcd); 
                if (F <= isPrime.length - 1 && isPrime[F]) {
                    count++;
                }
            }
        }
        return count;
    }
    private static int gcd(int a, int b, Map<String, Integer> gcdCache) {
        String key = a + "," + b;
        if (gcdCache.containsKey(key)) {
            return gcdCache.get(key);
        }
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        gcdCache.put(key, a);
        gcdCache.put(b + "," + a, a);
        return a;
    }
}
