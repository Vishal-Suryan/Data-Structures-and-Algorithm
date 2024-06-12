import java.util.Arrays;

public class maxTip {
    class Solution {
    public static long maxTip(int n, int x, int y, int[] arr, int[] brr) {
        Integer[] orderIndices = new Integer[n];
        for (int i = 0; i < n; i++) {
            orderIndices[i] = i;
        }

        // Sort the orders based on the difference in tips
        Arrays.sort(orderIndices, (i, j) -> Math.abs(brr[j] - arr[j]) - Math.abs(brr[i] - arr[i]));

        long totalTips = 0;
        int ordersA = 0;
        int ordersB = 0;

        for (int i : orderIndices) {
            if ((arr[i] > brr[i] && ordersA < x) || ordersB == y) {
                totalTips += arr[i];
                ordersA++;
            } else {
                totalTips += brr[i];
                ordersB++;
            }
        }

        return totalTips;
    }
}
}
