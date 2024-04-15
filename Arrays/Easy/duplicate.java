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
        int j=0;
        int[] filter_array=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            if(arr[i]==arr[i++]){
                continue;
            }
            filter_array[j++]=arr[i];
        }
        System.out.println("Filtered Array: "+Arrays.toString(filter_array));
        return;
    }
}
    