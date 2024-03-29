import java.util.*;
public class hash2 {
    static String inputString(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter A String: ");
        String str= sc.nextLine();
        return str;
    }

    public static int arr[]=new int[26];
    static int hashlowerCharacter(char chr, String str){
        for(int i =0; i<str.length();i++){
            arr[str.charAt(i)-'a']++;
        }
        System.out.println(arr[chr-'a']);
        return 0;
    }
    public static int arrr[]=new int[256];
    static int hashAllCharacter(char chr, String str){
        for(int i =0; i<str.length();i++){
            arrr[str.charAt(i)]++;
        }
        System.out.println(arrr[chr]);
        return 0;
    }
    public static void main(String [] args ){
        /* String a = inputString();
        System.out.println(a); */
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter Character: ");
        char chr= sc.next().charAt(0);
        hashAllCharacter(chr, inputString());
    }
}
