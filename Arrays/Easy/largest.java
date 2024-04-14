import java.util.*;
public class largest{
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter size: ");
        int size=sc.nextInt();
        int [] arr = new int[size];
        System.out.print("Enter Elements: ");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        largest(arr);
    }

    static void largest(int[] arr){
        int max= Integer.MIN_VALUE;
        for(int i=0;i < arr.length;i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }
        System.out.println("Largest Element in Array: "+max);
        return;
    }
}