public class revarray {
    public static void printarray(int n,int arr[]){
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
    static void revArray(int n,int start ,int arr[]){
        if(start>=n/2){
            printarray(n, arr);
            return ;
        }
        int temp=arr[start];
        arr[start]=arr[n-start-1];
        arr[n-start-1]=temp;
        revArray(n,start+1,arr);
    }
    public static void main (String[] args){
        int n=5;
        int arr[]={1,2,3,4,5};
        revArray(n, 0, arr);
       
    }
}
