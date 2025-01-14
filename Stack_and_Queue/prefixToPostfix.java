import java.util.Stack;

public class prefixToPostfix {
    class Solution {
    static String preToPost(String pre_exp) {
        // code here
        Stack<String> st=new Stack<>();
        StringBuilder sb=new StringBuilder(pre_exp);
        for(int i=sb.length()-1;i>=0;i--){
            char chr=sb.charAt(i);
            if(Character.isLetterOrDigit(chr)){
                st.push(Character.toString(chr));
            }else{
                String t1=st.pop();
                String t2=st.pop();
                String str=t1+t2+chr;
                st.push(str);
            }
        }
        return st.peek();
    }
}

}
