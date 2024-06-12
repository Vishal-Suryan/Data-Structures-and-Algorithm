
import java.util.ArrayList;
public class revPairs {
    class Solution {
        public static int countPairs(int[] arr, int low, int mid, int high) {
            int right = mid + 1;
            int cnt=0;
            for (int i = low; i <= mid; i++) {
                while (right <= high && arr[i] > (double)2 * arr[right]) right++;
                cnt += (right - (mid + 1));
            }
            return cnt;
        }
        private static void merge(int arr[],int low,int mid,int high){
            int left=low;
            int right=mid+1;
            ArrayList<Integer> temp =new ArrayList<>();
            while(left<=mid && right<=high){
                if(arr[left]<=arr[right]){
                    temp.add(arr[left]);
                    left++;
                }else{
                    temp.add(arr[right]);
                    right++;
                }
            }
            while(left<=mid){
                temp.add(arr[left]);
                left++;
            }
            while(right<=high){
                temp.add(arr[right]);
                right++;
            }
            for(int i=low;i<=high;i++){
                arr[i]=temp.get(i-low);
            }
        }
        public static int mergeSort(int[] arr, int low, int high) {
            int cnt = 0;
            if (low >= high) return cnt;
            int mid = (low + high) / 2 ;
            cnt += mergeSort(arr, low, mid);  // left half
            cnt += mergeSort(arr, mid + 1, high); // right half
            cnt += countPairs(arr, low, mid, high); //Modification
            merge(arr, low, mid, high);  // merging sorted halves
            return cnt;
        }
        public int reversePairs(int[] nums) {
            return  mergeSort(nums,0,nums.length-1);
            
        }
    }
}
