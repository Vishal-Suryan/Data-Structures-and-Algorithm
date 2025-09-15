class Solution { // This question can also be solved in O(N) TC using bucket sort.
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((b,a) -> b.freq - a.freq);
        for(int key : map.keySet()){
            pq.offer(new Pair(key, map.get(key)));
            if(pq.size() > k) pq.poll();
        }
        int[] res = new int[k];
        int i = pq.size() - 1;
        while(k > 0){
            res[i] = pq.poll().num;
            i--;
            k--;
        }
        return res;
    }
    record Pair(int num, int freq){}
}