import java.util.*;
public class consecutiveOne {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter size: ");
        int size=sc.nextInt();
        int [] arr = new int[size];
        System.out.print("Enter Elements: ");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(consecutiveOne(arr));
    }
    public static int consecutiveOne(int[] arr){
        int count =0;
        int maxcount=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1){
                count+=1;
            }else{
                maxcount=count;
                count=0;
            }
        }
        return (maxcount>count)? maxcount: count;
    }
}
