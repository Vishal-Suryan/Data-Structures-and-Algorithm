public class reverseString_344 {
    class Solution {
        public void reverseString(char[] s) {
            for(int i=0;i<s.length/2;i++){
                char temp=s[i];
                s[i]=s[s.length-1-i];
                s[s.length-1-i]=temp;
            }
            return;
        }
    }
}
