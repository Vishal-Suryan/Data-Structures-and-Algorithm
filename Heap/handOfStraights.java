class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        // Step 1: Frequency map
        Map<Integer, Integer> count = new HashMap<>();
        for(int card : hand){
            count.put(card, count.getOrDefault(card, 0) + 1);
        }
        // Step 2: Min-heap with all unique cards
        PriorityQueue<Integer> heap = new PriorityQueue<>(count.keySet());
        while(!heap.isEmpty()){
            int start = heap.peek(); // smallest available card
            // Try to build group of size = groupSize
            for(int i = 0; i < groupSize; i++){
                int card = start + i;
                if(!count.containsKey(card)) return false;
                // Decrease count
                count.put(card, count.get(card) - 1);
                if(count.get(card) == 0){
                    count.remove(card);
                    // Important: only remove from heap if it's the smallest
                    if(card != heap.peek()){
                        return false; // gap found
                    }
                    heap.poll();
                }
            }
        }
        return true;
    }
}