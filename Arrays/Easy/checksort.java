import java.util.*;
public class checksort {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter size: ");
        int size=sc.nextInt();
        int [] arr = new int[size];
        System.out.print("Enter Elements: ");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Is the Array Sorted ? "+check(arr));
    }
    
    static boolean checkIf_sorted(int[] arr){
        int [] sort =arr.clone();
        Arrays.sort(sort);
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=sort[i]){
                return false;
            }
        }
        return true;
    }

    static boolean check(int[] arr){
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]>arr[i]){
                return false;
            }
        }
        return true;
    }
}
