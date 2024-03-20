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
    public static void main(String[] args) {
        String str = "12madaM12";
        if(isPalindrome(str)==true){
            System.out.println("String is Palindrome");
        }else{
            System.out.println("String is not a Palindrome");
        }

    }
}
