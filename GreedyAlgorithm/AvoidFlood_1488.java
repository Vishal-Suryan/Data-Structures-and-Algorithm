class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        HashMap<Integer, Integer> fullLakes = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();
        for(int i = 0; i < n; i++){
            int lake = rains[i];
            if(lake > 0){
                if(fullLakes.containsKey(lake)){
                    int prevDay = fullLakes.get(lake);
                    Integer dryDay = dryDays.higher(prevDay);
                    if(dryDay == null) return new int[]{};
                    ans[dryDay] = lake;
                    dryDays.remove(dryDay); 
                }
                fullLakes.put(lake, i);
            }else{
                dryDays.add(i);
                ans[i] = 1;
            }
        }
        return ans;
    }
}