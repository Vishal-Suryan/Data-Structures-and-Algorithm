import java.util.*;
public class substringXorQueries_2560 {
    class Solution {
        public int[][] substringXorQueries(String s, int[][] queries) {
            int[][] res = new int[queries.length][2];
            Map<String, Integer> map = new HashMap<>();
            for(int i = 0; i<s.length(); i++){
                String str = "" + s.charAt(i);
                if(!map.containsKey(str)){
                    map.put(str, i);
                }
                if(s.charAt(i) == '1'){
                    for(int j = i+1; j < i+32 && j<s.length(); j++){
                        str+= s.charAt(j);
                        if(!map.containsKey(str)){
                            map.put(str, i);
                        }
                    }
                }
            }
            for(int i = 0; i<queries.length; i++){
                res[i][0] = -1;
                res[i][1] = -1;
                int xor = queries[i][0] ^ queries[i][1];
                String str = Integer.toBinaryString(xor);
                if(map.containsKey(str)){
                    res[i][0] = map.get(str);
                    res[i][1] = res[i][0] + str.length() - 1;
                }
            }
            return res;
        }
    }
}
