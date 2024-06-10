import java.util.LinkedHashMap;
import java.util.Map;

public class nutsandBolts {
    class Solution {
    static void rearrange(int n,char[] chars){
        char[] original={'!','#','$','%','&','*','?','@','^'};
        Map<Character,Integer> mp=new LinkedHashMap<>();
        for(int i=0;i<9;i++){
            mp.put(original[i],0);
        }
        for(char element:chars){
            mp.put(element,mp.get(element)+1);
        }
        int j=0;
        for(char key:mp.keySet()){
            if(mp.get(key)==1){
                chars[j]=key;
                j++;
            }
        }
        return;
        
    }
    static void matchPairs(int n, char nuts[], char bolts[]) {
        // code here
        rearrange(n,nuts);
        rearrange(n,bolts);
        return;
    }
}
}
