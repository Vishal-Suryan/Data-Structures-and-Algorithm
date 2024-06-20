public class maxOne {
    class Solution {
        // Method to find the first index in a row where the value is 1
        static int getOne(int[] arr, int m){
            int low = 0;
            int high = m - 1;
            int ans = m; // Default to m if no 1 is found
            while(low <= high){
                int mid = (low + high) / 2;
                if(arr[mid] >= 1){
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return ans;
        }
    
        // Method to find the row with the maximum number of 1s
        int rowWithMax1s(int arr[][], int n, int m) {
            int ans = -1;
            int max = 0;
            for(int i = 0; i < n; i++){
                int firstOneIndex = getOne(arr[i], m);
                int countOne = m - firstOneIndex;
                if(countOne > max) {
                    max = countOne;
                    ans = i;
                }
            }
            return ans;
        }
    }
}
