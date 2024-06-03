public class append_2486 {
    class Solution {
        public int appendCharacters(String s, String t) {
            int j=0;
            int i=0;
            while(i<s.length() && j<t.length()){
                if(s.charAt(i)==t.charAt(j)){
                    i++;
                    j++;
                }else{
                    i++;
                }
            }
            return t.length()-j;
        }
    }
}
