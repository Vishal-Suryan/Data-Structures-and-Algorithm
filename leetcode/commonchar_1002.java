import java.util.ArrayList;
import java.util.List;

public class commonchar_1002 {
    class Solution {
    public List<String> commonChars(String[] words) {
        List<String> res=new ArrayList<>();
        int [] common=new int[26];
        for(int ch :words[0].toCharArray()){
            int index= ch - 'a';
            common[index]++;
        }
        for(int i=1;i<words.length;i++){
            int [] current=new int[26];
            for(int ch: words[i].toCharArray()){
                int index= ch-'a';
                current[index]++;
            }
            for(int j=0;j<26;j++){
                common[j]=Math.min(common[j],current[j]);
            }
        }
        for(int i=0;i<26;i++){
            if(common[i]!=0){
                char ch = (char)(i+97);
                int count=common[i];
                while(count>0){
                    res.add(""+ch);
                    count--;
                }
            }
        }
        return res;
    }
}
}
