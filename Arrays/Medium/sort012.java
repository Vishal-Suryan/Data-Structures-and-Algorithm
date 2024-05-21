import java.util.*;
public class sort012 {
    public static void sortColors(int[] nums) {
        int count_0= 0, count_1= 0, count_2= 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count_0++;
            }else if(nums[i]==1){
                count_1++;
            }else{
                count_2++;
            }
        }
        for(int i=0;i<count_0;i++){
            nums[i]=0;
        }
        for(int i=count_0;i<count_0+count_1;i++){
            nums[i]=1;
        }
        for(int i=count_0+count_1;i<nums.length;i++){
            nums[i]=2;
        }
        System.out.println(Arrays.toString(nums));
        return;
    }
    
    public void sortColors1(int[] arr) {// dutch national flag algo
        int low=0,mid=0,high=arr.length-1;
        while(mid<=high){
            if(arr[mid]==0){
                int temp = arr[low];
                arr[low]=arr[mid];
                arr[mid]=temp;
                low++;
                mid++;
            }else if(arr[mid]==1){
                mid++;
            }else{
                int temp = arr[mid];
                arr[mid]=arr[high];
                arr[high]=temp;
                high--;
            }
        }
        return;
    }


    public static void main(String[] args){
        int [] arr = {0,2,2,2,1};
        sortColors(arr);
    }

}
