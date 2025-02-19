import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class wordLadder2 {
    // Brute Force //
    class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord,
        List<String> wordList) {
            Set<String> st = new HashSet<>();
            for(String str : wordList){
                st.add(str);
            }
            Queue<ArrayList<String>> q = new LinkedList<>();
            ArrayList<String> ls = new ArrayList<>();
            ls.add(beginWord);
            q.offer(ls);
            ArrayList<String> usedOnLevel = new ArrayList<>();
            usedOnLevel.add(beginWord);
            int level = 0;
            List<List<String>> ans = new ArrayList<>();
            while(!q.isEmpty()){
                ArrayList<String> vec = q.poll();
                if(vec.size() > level){
                    level++;
                    for(String str : usedOnLevel){
                        st.remove(str);
                    }
                }
                String word = vec.get(vec.size() - 1);
                if(word.equals(endWord)){
                    if(ans.size() == 0){
                        ans.add(vec);
                    }else if(ans.get(0).size() == vec.size()){
                        ans.add(vec);
                    }
                }
                for(int i = 0; i<word.length(); i++){
                    for(char ch = 'a'; ch<='z'; ch++){
                        char[] replacedCharArray = word.toCharArray();
                        replacedCharArray[i] = ch;
                        String replacedWord = new String(replacedCharArray);
                        if(st.contains(replacedWord)){
                            vec.add(replacedWord);
                            ArrayList<String> temp = new ArrayList<>(vec);
                            q.add(temp);
                            usedOnLevel.add(replacedWord);
                            vec.remove(vec.size() - 1);
                        }
                    }
                }
            }
            return ans;
        }
    }
    
}
