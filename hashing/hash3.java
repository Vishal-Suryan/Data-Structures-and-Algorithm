import java.util.*;
public class hash3 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter A String: ");
        String str=sc.next();

        int hash[]= new int[256];
        for(int i=0;i<str.length();i++){
            hash[str.charAt(i)]++;
        }

        System.out.print("Enter the size of Input Array: ");
        int size=sc.nextInt();
        while(size>=0){
            System.out.print("Enter Character: ");
            char chr = sc.next().charAt(0);
            System.out.println("Frequency in String: "+hash[chr]);    
            size--;
        }
    }
}
