import java.util.*;
public class mergesort {
    private static void merge(int arr[],int low,int mid,int high){
        int left=low;
        int right=mid+1;
        ArrayList<Integer> temp =new ArrayList<>();
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                right++;
            }
        }
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        while(right<=high){
            temp.add(arr[right]);
            right++;
        }
        for(int i=low;i<=high;i++){
            arr[i]=temp.get(i-low);
        }
    }
    static void mergeSort(int arr[],int low,int high){
        if(low>=high){
            return ;
        }
        int mid=(low+high)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);

    }
    
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("Input Array Size: ");
        int size=sc.nextInt();
        System.out.print("Enter Elements: ");
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Input Array: "+Arrays.toString(arr));
        mergeSort(arr,0, size-1);
        System.out.println("Sorted Array: "+Arrays.toString(arr));
    }
}
