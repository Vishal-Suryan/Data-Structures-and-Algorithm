class Solution {
    static int[] replaceWithRank(int arr[], int N) {
        // code here
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.first - y.first);
        for(int i = 0; i < N; i++){
            pq.offer(new Pair(arr[i], i));
        }
        int rank = 0;
        int prevVal = Integer.MIN_VALUE;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int val = p.first;
            int idx = p.second;
            if(val != prevVal){
                prevVal = val;
                rank++;
            }
            arr[idx] = rank;
        }
        return arr;
    }
    static class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
}
