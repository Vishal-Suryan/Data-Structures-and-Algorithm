public class checkPal_string {
    static boolean isPalindrome(String str){
        int left=0;
        int right= str.length()-1;
        while(left<right){
            char l=str.charAt(left);
            char r=str.charAt(right);
            if(!Character.isLetterOrDigit(l)){
                left++;
            }else if(!Character.isLetterOrDigit(r)){
                right--;
            }else if(Character.toLowerCase(l)!=Character.toLowerCase(r)){
                return false;
            }else{
                left++;
                right--;
            }
        }
        return true;
    }
    public static boolean palindrome(int i,String str){
        //base condition
        if(i>=str.length()/2){
            return true;
        }
        if(Character.toLowerCase(str.charAt(i))!= Character.toLowerCase(str.charAt(str.length()-i-1))){
            return false;
        }
        palindrome(i+1, str);
        return true;

    }
    public static void main(String[] args) {
        String str = "Madam";
        System.out.println(palindrome(0, str));
        if(isPalindrome(str)==true){
            System.out.println("String is Palindrome");
        }else{
            System.out.println("String is not a Palindrome");
        }

    }
}
