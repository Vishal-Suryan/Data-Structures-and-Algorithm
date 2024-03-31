import java.util.*;
public class selectionsort{
    public static int selectionSort(int array[]){
        int size = array.length;
        for(int i=0;i<=size-2;i++){
            int minElement=i;
            for(int j=i+1;j<=size-1;j++){
                if(array[j]<array[minElement]){
                    minElement=j;
                }
            }
            
            int temp = array[minElement];
            array[minElement] = array[i];
            array[i] = temp;
        }
        System.out.println("Sorted Array: "+Arrays.toString(array));
        return 0;
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
        selectionSort(arr);
    }
}