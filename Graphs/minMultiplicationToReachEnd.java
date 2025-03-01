import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class minMultiplicationToReachEnd {
    class Solution {
        class Pair{
            int first;
            int second;
            public Pair(int first, int second){
                this.first = first;
                this.second = second;
            }
        }
        int minimumMultiplications(int[] arr, int start, int end) {
            // Your code here
            if(start == end) return 0;
            Queue<Pair> q = new LinkedList<>();
            q.offer(new Pair(start, 0));
            int[] dist = new int[100000];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[start] = 0;
            int mod = (int)Math.pow(10,5);
            while(!q.isEmpty()){
                Pair temp = q.poll();
                int node = temp.first;
                int steps = temp.second;
                for(int itr : arr){
                    int num = (node * itr) % mod;
                    if(steps + 1 < dist[num]){
                        dist[num] = steps + 1;
                        if(num == end) return steps + 1;
                        q.offer(new Pair(num, steps + 1));
                    }
                }
            }
            return -1;
        }
    }
}
