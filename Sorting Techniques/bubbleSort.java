import java.util.*;
public class bubbleSort {

    public static void bubbleSort(int arr[]){
        for(int i=arr.length-1;i>=0;i--){
            int swap=0;
            for(int j=0;j<=i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swap=1;
                }
            }
            if(swap==0){
                break;
            }
        }
        System.out.println("Sorted Array: "+Arrays.toString(arr));
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
        bubbleSort(arr);
    }
}
