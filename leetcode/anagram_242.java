public class anagram_242 {
    class Solution {
        public boolean isAnagram(String s, String t) {
            if(s.length()!=t.length()){
                return false;
            }
            int[] hash=new int[27];
            for(char chr: s.toCharArray()){
                hash[chr-'a']++;
            }
            for(char chr:t.toCharArray()){
                if(hash[chr-'a']!=0){
                    hash[chr-'a']--;
                }else{
                    return false;
                }
            }
            return true;
        }
    }
}
