import java.util.Stack;

public class postfixToInfix {
    class Solution {
    static String postToInfix(String exp) {
        // code here
        Stack<String> st=new Stack<>();
        StringBuilder sb=new StringBuilder(exp);
        for(int i=0;i<sb.length();i++){
            char chr=sb.charAt(i);
            if(Character.isLetterOrDigit(chr)){
                st.push(Character.toString(chr));
            }else{
                String t2=st.pop();
                String t1=st.pop();
                String str="("+t1+chr+t2+")";
                st.push(str);
            }
        }
        return st.peek();
    }
}
}
