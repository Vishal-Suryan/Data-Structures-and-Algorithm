class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char chr : tasks){
            freq[chr - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int f : freq){
            if(f > 0) maxHeap.add(f);
        }
        int time = 0;
        while (!maxHeap.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;  // one round = n+1 slots
            // Run up to n+1 tasks in this round
            while(cycle > 0 && !maxHeap.isEmpty()){
                int current = maxHeap.poll();
                if(current > 1){
                    temp.add(current - 1);  // task not finished yet
                }
                time++;
                cycle--;
            }
            // Push remaining tasks back into heap
            for(int remaining : temp){
                maxHeap.add(remaining);
            }
            // If heap not empty, but cycle not completed → we must count idle slots
            if(!maxHeap.isEmpty()){
                time += cycle; // add the idle time
            }
        }
        return time;
    }

    public int leastInterval1(char[] tasks, int n) {
        int maxFreq = -1;
        int nMaxFreq = 0;
        int[] hash = new int[26];
        for(char chr : tasks){
            hash[chr - 'A']++;
            maxFreq = Math.max(maxFreq, hash[chr - 'A']);
        }
        for(int freq : hash){
            if(freq == maxFreq) nMaxFreq++;
        }
        return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + nMaxFreq);
    }

}