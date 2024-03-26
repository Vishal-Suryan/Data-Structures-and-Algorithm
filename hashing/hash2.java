import java.util.*;
public class hash2 {
    static String inputString(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter A String: ");
        String str= sc.nextLine();
        return str;
    }

    public static int arr[]=new int[266];
    static int hashCharacter(char chr, String str){
        for(int i =0; i<str.length();i++){
            if(str.charAt(i)==chr){
                int index=str.charAt(i)-'a';
                arr[index]+=1;
            }
        }
        System.out.println(arr[chr-'a']);
        return 0;
    }
    public static void main(String [] args ){
        /* String a = inputString();
        System.out.println(a); */
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter Character: ");
        char chr= sc.next().charAt(0);
        hashCharacter(chr, inputString());
    }
}
