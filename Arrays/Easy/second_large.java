import java.util.*;
public class second_large{
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter size: ");
        int size=sc.nextInt();
        int [] arr = new int[size];
        System.out.print("Enter Elements: ");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        sec_largest(arr);
        sec_smallest(arr);
    }

    static void sec_largest(int[] arr) {
        if (arr.length < 2) {
            System.out.println("Array is too small to have a second largest element");
            return;
        }
        int max = arr[0];
        int max2 = arr[1]; // Initialize max2 assuming at least two elements
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] > max) {
                max2 = max;
                max = arr[i];
            } else if (arr[i] > max2 && arr[i] != max) {
                max2 = arr[i];
            }
        }
        System.out.println("Second Largest Element in Array: " + max2);
        
    }
    static void sec_smallest(int[] arr) {
        if (arr.length < 2) {
            System.out.println("Array is too small to have a second smallest element");
            return;
        }
        int min = arr[0];
        int min2 = Integer.MAX_VALUE; // Initialize min2 to a larger value
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {  // Update min2 whenever a new element is less than min
                min2 = min;
                min = arr[i];
            } else if (arr[i] < min2 && arr[i] > min) {
                min2 = arr[i];
            }
        }
        System.out.println("Second Smallest Element in Array: " + min2);
    }
    
    
    
    
}