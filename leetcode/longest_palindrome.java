import java.util.HashSet;
import java.util.Set;

public class longest_palindrome {
    class Solution {
    public int longestPalindrome(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int res=0;
        Set <Character> mp=new HashSet<>();
        for(char ch : s.toCharArray()){
            if(mp.contains(ch)){
                res+=2;
                mp.remove(ch);
            }else{
                mp.add(ch);
            }
        }
        return (mp.size()==0)? res : res+1 ;
    }
}
}
