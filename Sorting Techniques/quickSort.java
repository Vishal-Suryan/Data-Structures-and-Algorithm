import java.util.*;
class quickSort{
    static int partition(int[] arr,int low,int high){
        int pivot=arr[low];
        int i=low;
        int j=high;
        while(i<j){
            while(arr[i]<=pivot && i<=high-1){
                i++;
            }
            while(arr[j]>pivot && j>=low+1){
                j--;
            }
            if(i<j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp =arr[low];
        arr[low]=arr[j];
        arr[j]=temp;

        return j;
    }
    static void quickSort(int[]arr,int low,int high){
        if(low<high){
            int pIndex=partition(arr,low,high);
            quickSort(arr, low, pIndex-1);
            quickSort(arr, pIndex+1, high);
        }
        return;
    }
    
    public static void main(String []args){
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter the Size of Array: ");
        int n=sc.nextInt();
        int [] array=new int[n];
        System.out.print("Enter Elements: ");
        for(int i=0;i<n;i++){
            array[i]=sc.nextInt();
        }
        System.out.println("Input Array: "+Arrays.toString(array));
        quickSort(array, 0, n-1);
        System.out.println("Output Array: "+Arrays.toString(array));
    }
}