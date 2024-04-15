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
        remove_duplicate(arr);
    }
    static void remove_duplicate(int[] arr){
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
}
    