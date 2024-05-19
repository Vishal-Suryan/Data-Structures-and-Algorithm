import java.util.*;
public class leftRotate{
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter size: ");
        int size=sc.nextInt();
        int [] arr = new int[size];
        System.out.print("Enter Elements: ");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        leftRotate(arr);
    }
    static void left_rotate(int [] arr){
        int j=0;
        int [] temp= new int[arr.length];
        for(int i=0;i<arr.length-1;i++){
            if(i==0){
                temp[arr.length-1]=arr[0];
            }
            temp[j]=arr[i+1];
            j++;

        }
        System.out.print("Left Rotated Array: "+Arrays.toString(temp));
        return;
    }
    static void leftRotate(int[] nums){
        int temp= nums[0];
        for(int i=1;i<nums.length;i++){
            nums[i-1]=nums[i];
        }
        nums[nums.length-1]=temp;
        System.out.print("Left Rotated Array By one place: "+Arrays.toString(nums));
        return;
    }

}