public class sqrt {
    class Solution
{
     long floorSqrt(long x)
	 {
		// Your code here
		long low=1;
		long high=x;
		while(low<=high){
		    long mid=(low+high)/2;
		    if(mid * mid == x){
		        return mid;
		    }else if(mid * mid < x){
		        low=mid+1;
		    }else{
		        high=mid-1;
		    }
		}
		return high;
	 }
}
}
