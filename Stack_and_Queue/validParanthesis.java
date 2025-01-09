import java.util.Stack;

public class validParanthesis {
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> st=new Stack<>();
            for(char ch:s.toCharArray()){
                if(ch =='(' || ch =='{' || ch =='['){
                    st.push(ch);
                }else{
                    if(st.isEmpty()) return false;
                    char top=st.pop();
                    if(top=='(' && ch!=')') return false;
                    if(top=='[' && ch!=']') return false;
                    if(top=='{' && ch!='}') return false;
                }
            }
            return st.isEmpty();
        }
    }
}
