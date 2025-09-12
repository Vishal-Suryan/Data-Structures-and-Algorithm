class Solution {
    static String isKSortedArray(int arr[], int n, int k) {
        // code here
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b) {
                return a.first - b.first; 
            }
        });
        for(int i = 0; i < n; i++){
            pq.offer(new Pair(arr[i], i));
        }
        boolean flag = true;
        int exp = 0;
        while(!pq.isEmpty()){
            int idx = pq.poll().second;
            if(Math.abs(idx - exp) > k){
                flag = false;
                break;
            }
            exp++;
        }
        return (flag) ? "Yes" : "No";
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