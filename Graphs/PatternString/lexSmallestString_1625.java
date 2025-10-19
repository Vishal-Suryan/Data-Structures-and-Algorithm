public class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        String ans = s;
        int n = s.length();
        Deque<String> queue = new ArrayDeque<>();
        Set<String> seen = new HashSet<>();
        queue.offer(s);
        seen.add(s);
        while(!queue.isEmpty()){
            String curr = queue.poll();
            if(curr.compareTo(ans) < 0){
                ans = curr;
            }
            // Operation 1: add to odd indices
            char[] arr = curr.toCharArray();
            for (int i = 1; i < n; i += 2) {
                int d = (arr[i] - '0' + a) % 10;
                arr[i] = (char) (d + '0');
            }
            String added = new String(arr);
            if(seen.add(added)){
                queue.offer(added);
            }
            // Operation 2: rotate right by b
            String rotated = curr.substring(n - b) + curr.substring(0, n - b);
            if(seen.add(rotated)){
                queue.offer(rotated);
            }
        }
        return ans;
    }
}
