import java.util.Stack;
public class infixToPrefix {
    
public class Main {
  public static void main(String[] args) {
    String s = ("(p+q)*(c-d)");
    System.out.println("Infix expression: " + s);
    System.out.print("Prefix expression: ");
    System.out.print(infixToPrefix(s));
  }

  public static String infixToPrefix(String s) {
    StringBuilder str = reverseString(s);
    return helper(str);
  }
  public static StringBuilder reverseString(String str) {
  StringBuilder sb = new StringBuilder(str).reverse();
  for(int i=0;i<sb.length();i++){
      if (sb.charAt(i) == '(') {
          sb.setCharAt(i, ')');
      } else if (sb.charAt(i) == ')') {
          sb.setCharAt(i, '(');
      }
  }
  return sb;
  }
  public static String helper(StringBuilder s) {
  // Your code here
  StringBuilder ans = new StringBuilder();
  Stack<Character> st=new Stack<>();
  for(int i=0;i<s.length();i++){
      char chr=s.charAt(i);
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
        if(chr=='^'){
            while(!st.isEmpty() && priority(st.peek()) >= priority(chr)){
                ans.append(st.pop());
            }
            st.push(chr);
        }
      }
  }
  while(!st.isEmpty()){
      ans.append(st.pop());
  }
  return ans.reverse().toString();
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
}
