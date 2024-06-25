
public class parenthesis {
    class Solution {
        public String removeOuterParentheses(String s) {
            StringBuilder sb=new StringBuilder("");
            int x=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='('){
                    x++;
                    if(x>1){
                        sb.append(s.charAt(i));
                    }
                }else if(s.charAt(i)==')'){
                    x--;
                    if(x>0){
                        sb.append(s.charAt(i));
                    }
                }
            }
            return sb.toString();
        }
    }
}
