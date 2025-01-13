import java.util.Stack;

class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String s) {
        // Your code here
        StringBuilder ans = new StringBuilder();
        Stack<Character> st=new Stack<>();
        for(char chr : s.toCharArray()){
            if (Character.isLetterOrDigit(chr)) {
                ans.append(chr);
            }else if(chr=='('){
                st.push(chr);
            }else if(chr==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    ans.append(st.pop());
                }
                st.pop();
            }else{
                while(!st.isEmpty() && priority(chr)<=priority(st.peek())){
                    ans.append(st.pop());
                }
                st.push(chr);
            }
        }
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.toString();
    }
    private static int priority(char chr){
        if(chr=='^'){
            return 3;
        }
        if(chr=='*' || chr=='/'){
            return 2;
        }
        if(chr=='+' || chr=='-'){
            return 1;
        }
        return -1;
    }
}