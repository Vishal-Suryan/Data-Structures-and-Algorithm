public class countSubstringForAllVowelnKConsonants_3306 {
    class Solution {
        public long countOfSubstrings(String word, int k) {
            return atLeast(k, word) - atLeast(k + 1, word);
        }
        private boolean isConsonant(char ch){
            return (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u');
        }
        private boolean isAllVowelPresent(int[] freq){
            return (freq['a' - 'a'] > 0 && freq['e' - 'a'] > 0 && freq['i' - 'a'] > 0 
            && freq['o' - 'a'] > 0 && freq['u' - 'a'] > 0);
        }
        private long atLeast(int k, String words){
            long count = 0;
            int curConsonant = 0;
            int[] freq = new int[26];
            int n = words.length();
            int left = 0;
            for(int right = 0; right < n; right++){
                char ch = words.charAt(right);
                if(isConsonant(ch)){
                    curConsonant++;
                }
                freq[ch - 'a']++;
                while(curConsonant >= k && isAllVowelPresent(freq)){
                    count += (n - right);
                    char c = words.charAt(left);
                    if(isConsonant(c)){
                        curConsonant--;
                    }
                    freq[c - 'a']--;
                    left++;
                }
            }
            return count;
        }
    }
}
