class Solution {
    static void convertMinToMaxHeap(int N, int arr[]) {
        // code here
        for(int i = (N - 2) / 2; i >= 0; --i){
            MaxHeapify(arr, i, N);
        }
        return;
    }
    static void MaxHeapify(int[] arr, int i, int N){
        int left = (2 * i) + 1; 
        int right = (2 * i) + 2; 
        int largest = i;
        if(left < N && arr[left] > arr[i]){
            largest = left;
        }
        if(right < N && arr[right] > arr[largest]){
            largest = right;
        }
        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            MaxHeapify(arr, largest, N);
        }
        
    }
}
