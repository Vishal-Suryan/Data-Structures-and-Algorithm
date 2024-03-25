import java.util.*;
public class hash1 {
    public static int[] inputArray(int n){
        int arr[]=new int[n];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<n;i++){
            System.out.print("Enter Number: ");
            arr[i]=sc.nextInt();
        }
        return arr;   
    }
    static int printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        return 0;
    }
    public static void main(String[] args) {
        printArray(inputArray(3));
    }
}
