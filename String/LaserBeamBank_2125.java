class Solution {
    public int numberOfBeams(String[] bank) {
        int prevOneCount = 0;
        int beamCount = 0;
        for(String str : bank){
            int currOneCount = 0;
            if(str.indexOf("1") != - 1){
                for(char chr : str.toCharArray()){
                    if(chr == '1'){
                        currOneCount++;
                    }
                }
                if(currOneCount > 0){
                    beamCount += prevOneCount * currOneCount;
                }
                prevOneCount = currOneCount;
            }
        }
        return beamCount;
    }
}