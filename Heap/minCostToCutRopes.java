class Solution {
    public static int minCost(int[] arr) {
        // code here
        if(arr.length == 1) return 0;
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : arr) pq.offer(num);
        while(!pq.isEmpty()){
            if(pq.size() == 1){
                break;
            }
            int min1 = pq.poll();
            int min2 = pq.poll();
            sum += min1 + min2;
            pq.offer(min1 + min2);
        }
        return sum;
    }
}