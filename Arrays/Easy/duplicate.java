import java.util.*;
public class duplicate {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter size: ");
        int size=sc.nextInt();
        int [] arr = new int[size];
        System.out.print("Enter Elements: ");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
       // remove_duplicate(arr);
       int k=removeDuplicates(arr);
       for(int i=0;i<k;i++){
            System.out.print(arr[i]+" ");
       }
    }
    static void remove_duplicate(int[] arr){//TC and SC == O(n) METHOD -1 
        int j=1;
        int[] filter_array=new int[arr.length];
        filter_array[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]==arr[i]){
                continue;
            }
            filter_array[j++]=arr[i];
        }
        filter_array = Arrays.copyOf(filter_array, j);
        System.out.println("Filtered Array: "+Arrays.toString(filter_array));
        return;
    }
    static int removeDuplicates(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }

}
    