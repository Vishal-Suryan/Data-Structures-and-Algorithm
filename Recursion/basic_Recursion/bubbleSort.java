import java.util.*;
public class bubbleSort {

    public static void bubbleSort(int arr[],int n){
        int swap=0;
        if(n==1){
            return;
        }
        for(int i=0;i<=n-2;i++){
            if(arr[i]>arr[i+1]){
                int temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
                swap=1;
            }
        }
        if(swap==0){
            return;
        }
        bubbleSort(arr,n-1);
    }
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter the size of Array: ");
        int size= sc.nextInt();
        int [] arr=new int[size];
        System.out.print("Enter Elements: ");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Input Array: "+Arrays.toString(arr));
        bubbleSort(arr,size);
        System.out.println("Sorted Array: "+Arrays.toString(arr));
    }
}
