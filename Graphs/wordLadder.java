import java.util.*;
public class wordLadder {
    class Solution {
        class Pair{
            String first;
            int second;
            public Pair(String first, int second){
                this.first=first;
                this.second=second;
            }
        }
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Queue<Pair> q = new LinkedList<>();
            q.offer(new Pair( beginWord, 1 ));
            Set<String> st = new HashSet<>();
            for(String str : wordList){
                st.add(str);
            }
            st.remove(beginWord);
            while(!q.isEmpty()){
                String word = q.peek().first;
                int steps = q.peek().second;
                q.poll();
                if(word.equals(endWord)) return steps;
                for(int i = 0; i<word.length(); i++){
                    for(char ch = 'a'; ch<='z'; ch++){
                        char[] replacedCharArray = word.toCharArray();
                        replacedCharArray[i] = ch;
                        String replacedWord = new String(replacedCharArray);
                        if(st.contains(replacedWord)){
                            st.remove(replacedWord);
                            q.offer(new Pair(replacedWord,steps+1));
                        }
                    }
                }
            }
            return 0;
        }
    }
}
