import java.util.*;
public class linearSearch{
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter size: ");
        int size=sc.nextInt();
        int [] arr = new int[size];
        System.out.print("Enter Elements: ");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("Enter the Element you want to Search? ");
        int search=sc.nextInt();
        linearSearch(arr, search);
    }
    static void linearSearch(int[] arr,int search){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==search){
                System.out.println("Element "+arr[i]+" found at index "+i);
            }else{
                System.out.println("Element not Found");
            }
        }
        return;
    }
}