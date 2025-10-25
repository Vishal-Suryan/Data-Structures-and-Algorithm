class Solution {
    public String lexSmallest(String s) {
        int n = s.length();
        String smallest = s;
        for(int k = 1; k <= n; k++){
            String first = new StringBuilder(s.substring(0, k)).reverse().toString() + s.substring(k);
            String last = s.substring(0, n - k) + new StringBuilder(s.substring(n - k)).reverse().toString();
            if(first.compareTo(smallest) < 0) smallest = first;
            if(last.compareTo(smallest) < 0) smallest = last;
        }
        return smallest;
    }
}