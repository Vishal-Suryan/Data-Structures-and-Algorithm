
public class floorSorted {
    class Solution{

        static int findFloor(long arr[], int n, long x)
        {
            int low = 0, high = n - 1;
            int floorIndex = -1;
            
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr[mid] <= x) {
                    floorIndex = mid;
                    low = mid + 1;
                } else { 
                    high = mid - 1;
                }
            }
            
            return floorIndex;
        }
    }
}
