class Solution {
    // record to keep sum and respective indices from both the array
    record Combination(int sum, int i, int j){};
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        // Create a maxHeap. It cpmpares the sum
        var heap =  new PriorityQueue<Combination>(
                    (c1, c2) -> Integer.compare(c2.sum, c1.sum));
        Arrays.sort(a);
        Arrays.sort(b);
        
        var i = a.length-1;
        var j = b.length-1;
        // Offer the last elements from both the array ( it gives max value)
        heap.offer(new Combination(a[i]+b[j], i, j));
        // Hashaset to handle the duplicate combination of indices.
        var uniqueSet = new HashSet<>();
        var result = new ArrayList<Integer>();
        while(result.size() < k){
            var currentComb = heap.poll();
            uniqueSet.add(currentComb);
            result.add(currentComb.sum);
            i = currentComb.i;
            j = currentComb.j;
            // make 2 new combination with indices [i-1,j] and [i, j-1]
            if(i>0){
                var comb1 = new Combination(a[i - 1]+b[j], i - 1, j);
                if(uniqueSet.add(comb1)){
                    heap.offer(comb1);
                }    
            }
            if(j>0){
                var comb2 = new Combination(a[i]+b[j-1], i, j-1);
                if(uniqueSet.add(comb2)){
                    heap.offer(comb2);
                }
            }
        }
        return result;
    }
}