class Solution {
    public List<String> removeAnagrams(String[] words){
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        for(int i = 1; i < words.length; i++){
            if(!isAnagram(ans.get(ans.size() - 1), words[i])){
                ans.add(words[i]);
            }
        }
        return ans;
    }
    private boolean isAnagram(String a, String b){
        if (a.length() != b.length()) return false;
        int[] cnt = new int[26];
        for(char c : a.toCharArray()){
            cnt[c - 'a']++;
        }
        for(char c : b.toCharArray()){
            cnt[c - 'a']--;
            if(cnt[c - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
