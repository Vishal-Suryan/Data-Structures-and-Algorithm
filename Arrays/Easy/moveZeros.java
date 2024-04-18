import java.util.*;
public class moveZeros {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter size: ");
        int size=sc.nextInt();
        int [] arr = new int[size];
        System.out.print("Enter Elements: ");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        moveToend(arr);
        System.out.print("Effective Array: "+Arrays.toString(arr));
    }
    /* public static int[] moveZerostoEnd(int []arr){
        int k=arr.length-1;
        for(int i=0;i<arr.length;i++){
            if(i<k){
                if(arr[i]==0){
                    int temp=arr[i];
                    for(int j=i;j<arr.length-1;j++){
                        arr[j]=arr[j+1];
                    }
                    arr[arr.length-1]=temp; 
                }
                k--;                      
            }
        }
        return arr;
    } */

    //approach
    //initialize a pointer to 0
    //iterate the array and check for non zero elements 
    //move the non-zero to the first place and increment the pointer  
    //after it iterates over the whole array you will have an array with non zero elements so,now initialize a for
    //loop from the pointer pos and fill the rest position with zero
    public static int [] moveToend(int[] arr){
        int idx=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                arr[idx]=arr[i];
                idx++;
            }
        }
        for(int i=idx;i<arr.length;i++){
            arr[i]=0;
        }
        return arr;
    }
}
