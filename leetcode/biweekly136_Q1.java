import java.util.HashMap;
import java.util.Map;

public class biweekly136_Q1 {
    class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        Map<Integer, Map<Integer, Integer>> playerColorCount = new HashMap<>();
        int ans = 0;
        for (int[] p : pick) {
            int player = p[0];
            int color = p[1];   
            playerColorCount.putIfAbsent(player, new HashMap<>());
            Map<Integer, Integer> colorCount = playerColorCount.get(player);
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
        }
        for (Map.Entry<Integer, Map<Integer, Integer>> entry:playerColorCount.entrySet()){
            int player = entry.getKey();
            Map<Integer, Integer> colorCount = entry.getValue(); 
            for (int count : colorCount.values()) {
                if (count > player) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
}
