class Solution {
    public boolean hasSameDigits(String s) {
        if(s.length() < 2) return false;
        int[] temp = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            temp[i] = s.charAt(i) - '0';
        }
        for(int i = temp.length; i > 2; i--){
            for(int j = 0; j < i - 1; j++){
                temp[j] = (temp[j] + temp[j + 1]) % 10;
            }
        }
        return temp[1] == temp[0];
    }
    public boolean hasSameDigits1(String s) {
        if(s.length() < 2) return false;
        StringBuilder sb = new StringBuilder(s);
        while(sb.length() != 2){
            int[] temp = new int[sb.length() - 1];
            for(int i = 0; i < sb.length() - 1; i++){
                int chr1 = sb.charAt(i) - '0';
                int chr2 = sb.charAt(i + 1) - '0';
                temp[i] = (chr1 + chr2) % 10;
            }
            sb.setLength(0);
            for(int num : temp){
                sb.append(num);
            }
        }
        if(sb.charAt(0) == (sb.charAt(1))) return true;
        return false;
    }
}