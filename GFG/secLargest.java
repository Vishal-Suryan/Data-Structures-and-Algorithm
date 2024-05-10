class Solution {
    int print2largest(int arr[], int n) {
        if(arr.length==1){
            return -1;
        }
        int max= Integer.MIN_VALUE;
        int max2= Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max2=max;
                max=arr[i];
            }else if(arr[i]>max2 && arr[i]!=max){
                max2=arr[i];
            }
        }
        return max2;
    }
}