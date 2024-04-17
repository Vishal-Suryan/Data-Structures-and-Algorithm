import java.util.*;
public class leftRotateD{
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter size: ");
        int size=sc.nextInt();
        int [] arr = new int[size];
        System.out.print("Enter Elements: ");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("By How many places you want to rotate the array: ");
        int rotateBy= sc.nextInt();
        left_rotateDd(arr,rotateBy);
    }
    /* static void left_rotateD(int [] arr, int rotateBy){
        int j=0;
        int [] temp= new int[arr.length];
        for(int i=0;i<arr.length;i++){
            if(i<=rotateBy){
                j=arr.length-rotateBy+i-1;
                temp[j]=arr[i];
            }else{
                temp[j]=arr[i];
                j++;
            }
        }
        System.out.print("Left Rotated Array by "+rotateBy+" places: "+Arrays.toString(temp));
        return;
    } */
    static void left_rotateDd(int[] arr, int rotateBy) {
        int n = arr.length;  
        int[] temp = new int[n];  
        for (int i = 0; i < n; i++) {
            int newIndex = (i + rotateBy) % n;  
            temp[newIndex] = arr[i];  
        }
        System.out.print("Left Rotated Array by "+rotateBy+" places: "+Arrays.toString(temp));
    }
    
}