class Solution {
    public int numberOfBeams(String[] bank) {
        int m = bank.length;
        int n = bank[0].length();
        int prevOneCount = 0;
        int prevRow = -1;
        int beamCount = 0;
        for(int i = 0; i < m; i++){
            String str = bank[i];
            int currOneCount = 0;
            if(str.indexOf("1") != - 1){
                for(char chr : str.toCharArray()){
                    if(chr == '1'){
                        currOneCount++;
                    }
                }
                if(prevOneCount != 0 && (i - prevRow > 0)){
                    beamCount += prevOneCount * currOneCount;
                }
                prevOneCount = currOneCount;
                prevRow = i;
            }
        }
        return beamCount;
    }
}