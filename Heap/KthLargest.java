class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        buildMaxHeap(nums);
        //System.out.println(Arrays.toString(nums));
        for (int i = n - 1; i >= n - k + 1; i--) {
            swap(nums, 0, i);    
            heapify(nums, 0, i);   
        }
        return nums[0];
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void buildMaxHeap(int[] nums){
        int n = nums.length;
        for(int i = n/2 - 1; i >= 0; i--){
            heapify(nums, i, n);
        }
    }
    public static void heapify(int[] nums, int i, int n){
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if(left < n && nums[left] > nums[largest]){
            largest = left;
        }
        if(right < n && nums[right] > nums[largest]){
            largest = right;
        }
        if(largest != i){
            int temp = nums[largest];
            nums[largest] = nums[i];
            nums[i] = temp;
            heapify(nums, largest, n);
        }
    }
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : nums){
            minHeap.offer(num);
            if(minHeap.size() > k){
                minHeap.poll(); 
            }
        }
        return minHeap.peek();
    }
}