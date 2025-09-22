class Solution {
    static class Process {
        int arrival, burst, idx;
        Process(int a, int b, int i) {
            arrival = a; burst = b; idx = i;
        }
    }

    public static ArrayList<Double> averageTimes(int n, int[] arrivalTime, int[] burstTime) {
        List<Process> processes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            processes.add(new Process(arrivalTime[i], burstTime[i], i));
        }

        // Sort by arrival time first
        processes.sort((a, b) -> a.arrival - b.arrival);

        // Min-heap based on burst time
        PriorityQueue<Process> pq = new PriorityQueue<>((a, b) -> 
            a.burst != b.burst ? a.burst - b.burst : a.arrival - b.arrival
        );

        int time = 0, i = 0;
        double totalTAT = 0, totalWT = 0;

        while (i < n || !pq.isEmpty()) {
            // Push all processes that have arrived by current time
            while (i < n && processes.get(i).arrival <= time) {
                pq.offer(processes.get(i));
                i++;
            }

            if (pq.isEmpty()) {
                // No process available, jump to next arrival
                time = processes.get(i).arrival;
                continue;
            }

            Process cur = pq.poll();
            time += cur.burst; // Completion time

            int tat = time - cur.arrival;       // Turnaround time
            int wt = tat - cur.burst;           // Waiting time

            totalTAT += tat;
            totalWT += wt;
        }

        ArrayList<Double> ans = new ArrayList<>();
        ans.add(totalWT / n);
        ans.add(totalTAT / n);
        return ans;
    }
}