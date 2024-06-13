
/* public class ceiltheFloor {
    class Solve {
        Pair getFloorAndCeil(int[] arr, int n, int x) {
            // code here
            int f=-1;
            int c=-1;
            for(int ele:arr){
                if(ele<=x && (f<ele || f==-1)){
                    f=ele;
                }
                if(ele>=x && (c>ele || c==-1)){
                    c=ele;
                }
            }
            return new Pair(f,c);
        }
    }
    
} */
