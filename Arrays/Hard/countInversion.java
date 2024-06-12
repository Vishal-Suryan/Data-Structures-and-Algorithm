import java.util.ArrayList;
public class countInversion {
   

public class countInversions {
    class Solution
{
    static int count=0;
    static long inversionCount(long arr[], long N)
    {
        mergeSort(arr,0,(int)N-1);
        return  count;
    }
    private static void merge(long[] arr, int low, int mid, int high) {
        ArrayList<Long> temp = new ArrayList<>(); 
        int left = low;      
        int right = mid + 1;   
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                count+=(mid-left+1);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }    
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
        return ;
    }
    public static void mergeSort(long[] arr, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2 ;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high); 
        return ;
    }
}

}

}
