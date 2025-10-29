class Solution {
    public int smallestNumber(int n) {
        String binary = Integer.toBinaryString(n);
        int len = binary.length();
        String ans = "1".repeat(len);
        return Integer.parseInt(ans, 2);
    }
}