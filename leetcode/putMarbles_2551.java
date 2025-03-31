import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class putMarbles_2551 {
    class Solution {
    public long putMarbles(int[] weights, int k) {
        if (k == 1) return 0;
        List<Integer> splits = new ArrayList<>();
        for (int i = 0; i < weights.length - 1; i++) {
            splits.add(weights[i] + weights[i + 1]);
        }
        Collections.sort(splits);
        long maxScore = 0, minScore = 0;
        int j = splits.size() - 1;
        for (int i = 0; i < k - 1; i++) {
            minScore += splits.get(i);   
            maxScore += splits.get(j--); 
        }
        return maxScore - minScore;
    }
}
}
