import java.util.Stack;

public class postfixToPrefix {
    class Solution {
    static String postToPre(String post_exp) {
        // code here
        Stack<String> st=new Stack<>();
        StringBuilder sb=new StringBuilder(post_exp);
        for(int i=0;i<sb.length();i++){
            char chr=sb.charAt(i);
            if(Character.isLetterOrDigit(chr)){
                st.push(Character.toString(chr));
            }else{
                String t2=st.pop();
                String t1=st.pop();
                String str=chr+t1+t2;
                st.push(str);
            }
        }
        return st.peek();
    }
}

}
